/**
 * This java class contains the drawing of the Circle shape with a color. It is drawn by instantiating an Ellipse2D.Double object
 * with equal width and height.
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
import java.awt.geom.*;

public class Circle implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * The constructor of this Circle class takes in the x coordinate, the y coordinate, the size, and the color to be
     * used for the shape.
     * @param x
     * @param y
     * @param size
     * @param color
     */
    public Circle(double x,double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * The draw method for this class instantiates and draws an ellipse2D.Double object that makes up the circle.
     * The fields of this object are then passed in to the ellipse object to create the desired shape, and the
     * Graphics2D object is then used to set the color and fill the circle to create the drawing.
     */
    public void draw(Graphics2D g2d){
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,size,size);
        g2d.setColor(color);
        g2d.fill(circle);
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
     * The getSize() method simply returns the size of the object.
     */
    public double getSize(){
        return size;
    }



    /**
     * The adjustY() method does the same thing as adjustX(), but for the object's Y value.
     */
    public void adjustY(double distance){
        y = distance;
    }

    /**
     * ThegetX() method simply returns the current x value of the object.
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
      * The getWidth() method simply returns the current width value of the object. In this class' case, the width, height, and
      * size are all equal given that it is a circle.
     */
     public double getWidth(){
         return size;
     }

     /**
      * The getHeight() method simply returns the current width value of the object.In this class' case, the width, height, and
      * size are all equal given that it is a circle.
     */
     public double getHeight(){
         return size;
     }
}
