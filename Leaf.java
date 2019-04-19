/**
 * This java class contains the drawing of the leaf, which is used for both the Tree drawing and the Sunflower drawing.
 * It is made through creating a Path object curved to certain calculated points.
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
import java.awt.geom.Path2D;

public class Leaf implements DrawingObject {

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    /**
     * The constructor of this Leaf class takes in the x coordinate, the y coordinate, and the width and height
     * used for the shape, and accordingly passes them into the corresponding fields. As the leaf color will never change,
     * it also sets the color field here.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Leaf(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new Color(0,104,56);
    }

    /**
     * The draw method for this class instantiates and draws a Path2D.Double object.
     * The fields of this class are then passed in to this object (with some being
     * modified) to create the desired shape, and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x, y+height);
        path.curveTo(x,y+height,x+width/2,y+height*.7,x+width,y+height);
        path.curveTo(x+width, y+height, x+width/2,y,x,y+height);
        g2d.setColor(color);
        g2d.fill(path);

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
    /**
     * This method returns the value of the color field of the Leaf object.
     */
    public Color getColor(){
        return color;
    }


}
