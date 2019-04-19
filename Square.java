/**
 * This java class contains the drawing of the Square object. It simply makes use of the Rectangle2D.Double object and
 * passes in an equal width and height, which is this object's "size" field.
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
import java.awt.geom.Rectangle2D;

public class Square implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * The constructor of this Square class takes in the x coordinate, the y coordinate, the width and height, and the
     * color to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x
     * @param y
     * @param size
     * @param color
     */
    public Square(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * The draw method for this class instantiates and draws a Rectangle2D.Double object.
     * The fields of this class are then passed in to this object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        Rectangle2D.Double square = new Rectangle2D.Double(x,y,size,size);
        g2d.setColor(color);
        g2d.fill(square);

    }

    /**
     * The getSize() method returns the value of the object's size field.
     */
    public double getSize(){ return size;}

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
     * The getWidth() method simply returns the current width value of the object. In this object's case, the width and height
     * are the same with the size, given that it is a square.
     */
    public double getWidth(){
        return size;
    }

    /**
     * The getHeight() method simply returns the current width value of the object. In this object's case, the width and height
     * are the same with the size, given that it is a square.
    */

    public double getHeight(){
        return size;
    }

}
