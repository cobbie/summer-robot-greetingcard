/**
 * This java class contains the drawing of the Tree object. It creates the tree by making use of three objects: one
 * Rectangle, and two Leaf objects. It continuously draws the leaf objects after certain rotation to create the shape of
 * the top of a palm tree.
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

public class Tree implements DrawingObject {

    private double x;
    private double y;
    private double height;
    private double width;

    /**
     * The constructor of this Tree class takes in the x coordinate, the y coordinate, and the width and height to
     * be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Tree(double x, double y, double width, double height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    /**
     * The draw method for this class instantiates multiple shapes and objects (Leaf, Rectangle).
     * The fields of this class are then passed in to these objects to create the desired shape,
     * and the Graphics2D object is then used create the drawing using a for loop. Unlike other classes,
     * this class continuously draws the same Leaf object multiple times.
     * Transformations such as rotate are also done to make this possible.
     */
    public void draw(Graphics2D g2d){
        Rectangle trunk = new Rectangle((x+width/2)-14, y, new Color(117,76,41),24,400);
        Leaf leaf1 = new Leaf(x-10,y-70,150,80);
        Leaf leaf2 = new Leaf(x+130,y-70,150,80);


        trunk.draw(g2d);
        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(320),leaf1.getX()+leaf1.getWidth(),leaf1.getY()+leaf1.getHeight());

        for(int i=0;i<11;i++){
            if(i<=4){
                leaf1.draw(g2d);
                g2d.rotate(Math.toRadians(20),leaf1.getX()+leaf1.getWidth(),leaf1.getY()+leaf1.getHeight());
            }
            else if(i==5) {
                g2d.setTransform(reset);
                g2d.rotate(Math.toRadians(20),leaf1.getX()+leaf1.getWidth(),leaf1.getY()+leaf1.getHeight());
                leaf2.draw(g2d);
            }
            else{
                g2d.rotate(Math.toRadians(-20),leaf1.getX()+leaf1.getWidth(),leaf1.getY()+leaf1.getHeight());
                leaf2.draw(g2d);
            }

        }
        g2d.setTransform(reset);

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
