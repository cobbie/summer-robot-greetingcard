/**
 * This java class contains the drawing of the SemiCircle object. It simply makes use of a Path2D.Double object along with
 * its built-in methods moveTo, lineTo, and curveTo.
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

public class SemiCircle implements DrawingObject {

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    /**
     *  The constructor of this SemiCircle class takes in the x coordinate, the y coordinate, the width and height, and the
     *  color to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public SemiCircle(double x, double y, double width, double height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * The draw method for this class instantiates and draws a Path2D.Double object.
     * The fields of this class are then passed in to this object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        Path2D.Double path = new Path2D.Double();
        path.moveTo(x,y+height);
        path.lineTo(x+width,y+height);
        path.curveTo(x+width,y+height, x + width/2, y, x,y+height);
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
    public double getX(){ return x; }

    /**
     * The getY() method simply returns the current y value of the object.
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
     * The getHeight() method simply returns the current width value of the object.
    */
    public double getHeight(){
        return height;
    }
}
