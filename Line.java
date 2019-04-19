/**
 * This java class contains the drawing of the Line object. It simply uses a Line2D Object and passes in
 * the passed in x1, y1, x2, y2 parameters.
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

/** sources used for this file:
 * https://www.tutorialspoint.com/java/lang/math_abs_int.htm
 */
import java.awt.*;
import java.awt.geom.*;

public class Line implements DrawingObject{

    private double x;
    private double y;
    private double x2;
    private double y2;
    private Color color;

    /**
     * The constructor of this Line class takes in the x1, x2, y1, and y2 coordinates, alone with the Color to be used for the line.
     * It then passes these in to the corresponding fields.
     * @param x
     * @param y
     * @param x2
     * @param y2
     * @param color
     */
    public Line (double x,double y, double x2, double y2, Color color){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * The draw method for this class instantiates and draws a Line2D.Double object.
     * The fields of this class are then passed in to this object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        Line2D.Double line = new Line2D.Double(x,y,x2,y2);
        g2d.setColor(color);
        g2d.draw(line);
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
      * The getWidth() method simply returns the current width value of the object. For this line object, it makes use
      * of absolute value.
     */
     public double getWidth(){ return Math.abs(x2-x); }


    /**
     * The getHeight() method simply returns the current width value of the object. For this line object, it makes use of absolute value.
    */
    public double getHeight(){ return Math.abs(y-y2); }

}
