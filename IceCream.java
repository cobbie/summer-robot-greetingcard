/**
 * This java class contains the drawing of the ice cream, which is seen on the right side of the canvas.It makes
 * use of the composite shapes rectangle and semicircle to create each "layer" of the popsicle along with the popsicle stick.
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
public class IceCream implements DrawingObject {

    private double x;
    private double y;
    private double width;
    private double height;
    private Rectangle stick;
    private Rectangle layer1;
    private Rectangle layer2;
    private SemiCircle layer3;


    /**
     * The constructor of this class takes in the x coordinate, y coordinate, width, and height as parameters. These are
     * passed in to the corresponding fields of this object. Since this shape remains static in the canvas, its shapes are
     * instantiated here as well.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public IceCream(double x, double y, double width, double height){
        this.x = x;
        this.y=y;
        this.width = width;
        this.height = height;

        stick = new Rectangle((x+width/2)-(width/6)/2, y, new Color(204, 153, 128),width/6,height);
        layer1 = new Rectangle(x, y+height/4,new Color(190,230,238),width, 20);
        layer2 = new Rectangle(x, y+height/4*.4,Color.WHITE,width, 20);
        layer3 = new SemiCircle(layer2.getX(),layer2.getY()-40,layer2.getWidth(),layer2.getHeight()+20,new Color(241, 92,91));

    }

    /**
     * The draw method for this class draws multiple Rectangle and the Semicircle object instantiated in the constructor.
     * The fields of this object are then passed in to these objects (with some being
     * modified) to create the desired shape, and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        stick.draw(g2d);
        layer1.draw(g2d);
        layer3.draw(g2d);
        layer2.draw(g2d);
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
        x = distance;
    }


    /**
     * The adjustY() method does the same thing as adjustX(), but for the object's Y value.
     */
    public void adjustY(double distance){
        y = distance;
    }


    /**
     * The getX() method simply returns the current x value of the object.
     */
    public double getX(){
        return x;
    }

    /**
     * The getY() method simply returns the current y value of the object.
     */
    public double getY() {
        return y;
    }


     /**
      * The getWidth() method simply returns the current width value of the object.
     */
     public double getWidth(){ return width; }


    /**
     * The getHeight() method simply returns the current width value of the object.
    */
    public double getHeight(){ return height; }



}
