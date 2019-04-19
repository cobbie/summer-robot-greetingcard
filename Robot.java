/**
 * This java class contains the drawing of the Robot object, which is the central piece/drawing in this project.
 * This composite shape makes use of multiple DrawingObject objects to create the drawing.
 * Through interacting with other classes, it can move its arm, change its inner body color, and move left and right.
 * There are multiple additional methods that contribute to making these types of functionality possible.
 *
 * Jacob Uriel R. Quintos
 * April 1, 2019
 */

/*
I have not discussed the Java language code
in my program with anyone other than my instructor
or the teaching assistants assigned to this course.

I have not used Java language code obtained
from another student, or any other unauthorized
source, either modified or unmodified.

If any Java language code or documentation
used in my program was obtained from another source,
such as a text book or webpage, those have been
clearly noted with a proper citation in the comments
of my code.
*/

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Robot implements DrawingObject{
    private double x;
    private double y;
    private double width;
    private double height;
    private double rotation;
    private Color innerBodyColor;
    private Color color;
    private Rectangle arm;
    private Trapezoid bodyOutline;
    private Trapezoid body;
    private Trapezoid innerBody;
    private Line horLine1;
    private Line horLine2;
    private Line vertLine;
    private Circle outerEyeBlack;
    private Circle middleEyeGray;
    private Circle innerEyeWhite;
    private Rectangle vertRec;
    private Triangle leftTriangle;
    private Triangle rightTriangle;

    /**
     * The constructor of this Robot class takes in the x coordinate, the y coordinate, the width and height, and the
     * color to be used for the body as parameters. It then passes these in to the corresponding fields of the shape.
     * It also makes sets the values of moveDirectionRight, rotation, and innerBodyColor, as these initial values
     * are vital for when other classes interact and manipulate this object.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Robot(double x, double y, double width, double height, Color color){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        this.color = color;
        rotation = 0;
        innerBodyColor = new Color(23,20,51);

    }

    /**
     * The draw method for this class instantiates the multiple shapes that were set as fields.
     * The fields of this class are then passed in to this object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     * The order of drawings here are important as it is a composite drawing, along with having transformations such as
     * reset be a part of its drawing.
     */
    public void draw(Graphics2D g2d){

        bodyOutline = new Trapezoid(x-3,y-3,width+6,height+6,Color.BLACK);
        body = new Trapezoid(x,y, width,height,color);
        innerBody = new Trapezoid(x+58,y+192,139.816,239.457,innerBodyColor);
        horLine1 = new Line(x+35,y+193, (x+body.getWidth())-35, y+193, Color.BLACK);
        horLine2= new Line(x+20,y+280,(x+body.getWidth())-20, y+280, Color.BLACK);
        vertLine = new Line(x+body.getWidth()/2,y,x+body.getWidth()/2,y+body.getHeight(), Color.BLACK);
        outerEyeBlack = new Circle((x+body.getWidth()/2)-14, y+(body.getHeight()-innerBody.getHeight())/2,28,Color.BLACK);
        middleEyeGray = new Circle(outerEyeBlack.getX()+outerEyeBlack.getSize()/5,outerEyeBlack.getY()+outerEyeBlack.getSize()/5, 18,new Color(37,36,39));
        innerEyeWhite = new Circle(middleEyeGray.getX()+middleEyeGray.getSize()/5,middleEyeGray.getY()+middleEyeGray.getSize()/5, 11,Color.WHITE);
        vertRec = new Rectangle(innerBody.getX()+(innerBody.getWidth()/2)-5,innerBody.getY(),Color.BLACK,10,240);
        arm = new Rectangle(vertRec.getX(),vertRec.getY(),innerBodyColor,vertRec.getWidth(),vertRec.getHeight());
        leftTriangle = new Triangle(body.getX(),body.getY()+body.getHeight(), body.getX()+28, body.getY()+body.getHeight(), body.getX()+4,body.getY()+body.getHeight()-26,new Color(77,76,86));
        rightTriangle = new Triangle(body.getX()+body.getWidth()-28,body.getY()+body.getHeight(), body.getX()+body.getWidth(), body.getY()+body.getHeight(), body.getX()+body.getWidth()-4,body.getY()+body.getHeight()-26,new Color(77,76,86));


        AffineTransform reset = g2d.getTransform();
        bodyOutline.draw(g2d);
        body.draw(g2d);
        vertLine.draw(g2d);
        horLine1.draw(g2d);
        horLine2.draw(g2d);
        innerBody.draw(g2d);
        vertRec.draw(g2d);
        leftTriangle.draw(g2d);
        rightTriangle.draw(g2d);
        g2d.rotate(rotation, arm.getX(), arm.getY()+arm.getHeight());
        arm.draw(g2d);
        g2d.setTransform(reset);
        outerEyeBlack.draw(g2d);
        middleEyeGray.draw(g2d);
        innerEyeWhite.draw(g2d);

    }

    public void moveArmUp(double degrees){ rotation += degrees; }
    public double getRotation(){ return rotation; }
    public void changeInnerBodyColor(int color1, int color2, int color3){
        innerBodyColor = new Color(color1, color2, color3);
    }

    /**
     * This section contains the methods part of the DrawingObject interface which this class implements. These methods access and change
     * certain fields of the instantiated objects of this class. Usually, these methods are called from other classes that implement the
     * DrawingObject interface in order to get to specific coordinates, such as getting the midpoint or edge of an object.
     */

    /**
     * The adjustX() method changes the current object's x value by adding the passed in value.
     */

    public void adjustX(double distance){
        x += distance;
    }
    /**
     * The adjustY() method does the same thing as adjustX(), but for the object's Y value.
     */

    public void adjustY(double distance){
        y += distance;
    }

    /**
     * The getX() method simply returns the current x value of the object.
     */

    public double getX(){
        return x;
    }

    /**
     * tTe getY() method simply returns the current y value of the object.
     */
    public double getY(){
        return y;
    }

    /**
     * The getWidth() method simply returns the current width value of the object.
     */

    public double getWidth(){
        return width;
    }

    /**
   The getHeight() method simply returns the current width value of the object.
    */
    public double getHeight(){
        return height;
    }
}
