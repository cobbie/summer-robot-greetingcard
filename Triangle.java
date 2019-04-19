/**
 * This java class contains the drawing of the Triangle object. It simply uses a Path2D.Double object to create
 * the shape by making use of three x and y coordinates, which are passed in the constructor.
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

public class Triangle implements DrawingObject {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double width;
    private double height;
    private Color color;

    /**
     * The constructor of this Triangle class takes in the x1, x2, x3, y1, y2, and y3 coordinates along with the
     * color to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param color
     */
    public Triangle(double x1,double y1, double x2, double y2, double x3, double y3, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1=y1;
        this.y2=y2;
        this.y3=y3;
        this.color = color;
        this.width = this.x1 + this.x2;
        this.height = this.y2 + this.y3;
    }

    /**
     * The draw method for this class instantiates and draws a Path2D.Double object.
     * The fields of this class are then passed in to this object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     */
    public void draw(Graphics2D g2d){
        Path2D.Double path= new Path2D.Double();
        path.moveTo(x1,y1);
        path.lineTo(x2,y2);
        path.lineTo(x3,y3);
        path.lineTo(x1,y1);
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
        x1 = distance;
    }


     /**
      * The adjustY() method does the same thing as adjustX(), but for the object's Y value.
     */
     public void adjustY(double distance){
         y1 = distance;
     }


    /**
     * The getX() method simply returns the current x1 value of the object.
     */
    public double getX(){
        return x1;
    }

    /**
     * The getY() method simply returns the current y1 value of the object.
     */
    public double getY() {
        return y1;
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
