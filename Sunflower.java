/**
 * This java class contains the drawing of the Sunflower object, which is composed of the Sunflower head, the stem, its
 * leaves, and the pots. It makes use of different classes and shapes to create this. As this is an object that is animated,
 * there are multiple additional methods that help make its functionality possible.
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

public class Sunflower implements DrawingObject {

    private double x;
    private double y;
    private double rotation;
    private double leaf1Y;
    private double leaf2Y;
    private double sunflowerHeadSize;
    private double width;
    private double height;
    private boolean direction1;
    private Color centerColor;
    private Color petalColor;
    private Trapezoid pot;
    private Leaf leaf1;
    private Leaf leaf2;
    private Rectangle stem;
    private SunflowerHead sunflowerHead;

    /**
     * The constructor of this Sunflower class takes in the x coordinate, the y coordinate, the width and height, and the
     * colors to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * It also sets initial values for certain fields (leaf1Y, direction1, sunflowerHeadSize) as these initial values are
     * important to be set for when the object will interact with other classes for animation and manipulation.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param centerColor
     * @param petalColor
     */
    public Sunflower(double x, double y, double width, double height, Color centerColor, Color petalColor){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.centerColor = centerColor;
        this.petalColor = petalColor;
        leaf1Y = 0;
        leaf2Y = 0;
        direction1 = true;
        sunflowerHeadSize = 80;

    }

    /**
     * The draw method for this class instantiates multiple shapes and objects.
     * The fields of this class are then passed in to these objects to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     * Transformations such as rotate are also done for animation.
     */
    public void draw(Graphics2D g2d){
        AffineTransform reset = g2d.getTransform();
        sunflowerHead = new SunflowerHead(x,y,sunflowerHeadSize, centerColor, petalColor);
        pot = new Trapezoid(x, y + 165, sunflowerHead.getSize(), 80,new Color(101, 67, 33));
        stem = new Rectangle(x+sunflowerHead.getSize()/2, y+sunflowerHead.getSize(),new Color(0, 104,56), 6, 108);
        leaf1 = new Leaf(stem.getX()+ stem.getWidth()-3, stem.getY()-5 + leaf1Y,50, 40);
        leaf2 = new Leaf(stem.getX()-48, stem.getY()+30 + leaf2Y,50, 40);

        stem.draw(g2d);
        g2d.rotate(Math.toRadians(180), x + pot.getWidth()/2,pot.getY() + pot.getHeight()/2);
        pot.draw(g2d);
        g2d.setTransform(reset);
        leaf1.draw(g2d);
        leaf2.draw(g2d);

        g2d.setTransform(reset);
        g2d.rotate(rotation, x + sunflowerHead.getSize()/2, y + sunflowerHead.getSize()/2);
        sunflowerHead.draw(g2d);

    }

    /**
     * Adjusts leaf1Y distance.
     * @param distance
     */
    public void adjustLeaf1(double distance){ leaf1Y += distance; }

    /**
     * Adjusts leaf2Y distance.
     * @param distance
     */
    public void adjustLeaf2(double distance){
        leaf2Y += distance;
    }

    /**
     * Returns leaf1Y value,
     * @return leaf1Y
     */
    public double getLeaf1Y(){
        return leaf1Y;
    }

    /**
     * Returns direction1 value.
     * @return direction1
     */
    public boolean getDirection1(){
        return direction1;
    }

    /**
     * Changes direction1 value.
     */
    public void reverseDirection(){
        direction1 = !direction1;
    }

    /**
     * Sets centerColor to passed in color.
     * @param color
     */
    public void adjustCenterColor(Color color){
        centerColor = color;
    }

    /**
     * Sets petalColor to passed in color.
     * @param color
     */
    public void adjustPetalColor(Color color){
        petalColor = color;
    }

    /**
     * This method rotates the sunflower head by increasing the value of the rotation field by the value of the
     * passed in degrees parameter.
     */
    public void rotateSunflowerHead(double degrees){
        rotation += degrees;
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

     public double getWidth(){
         return width;
     }

    /**
     * The getHeight() method simply returns the current width value of the object.
    */

    public double getHeight(){
        return height;
    }


}
