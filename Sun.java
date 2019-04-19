/**
 * This java class contains the drawing of the Sun object. It makes use of the Square and Circle classes to create its
 * rays and center. It also has an additional method to allow it to rotate through interacting with other classes.
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

public class Sun implements DrawingObject {

    private double x;
    private double y;
    private double rotation;
    private double size;
    private Color color1;
    private Color color2;

    private Square rayBox1;
    private Square rayBox2;
    private Circle sunCenter;

    /**
     * The constructor of this Sun class takes in the x coordinate, the y coordinate, the width and height, and the
     * colors to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x
     * @param y
     * @param size
     * @param color1
     * @param color2
     */
    public Sun(double x, double y, double size, Color color1, Color color2) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color1 = color1;
        this.color2 = color2;
    }

    /**
     * The draw method for this class instantiates Square and Circle objects.
     * The fields of this class are then passed in to these object to create the desired shape,
     * and the Graphics2D object is then used create the drawing.
     * Transformations such as rotate are also done for animation.
     */
    public void draw(Graphics2D g2d){
        rayBox1 = new Square(x,y, 80.052, color1);
        rayBox2 =  new Square(x,y, 80.052,color1);
        sunCenter = new Circle(x+ 6,y+8, size, color2);

        AffineTransform reset = g2d.getTransform();
        g2d.rotate(rotation, x + rayBox2.getSize()/2, y + rayBox2.getSize()/2);
        rayBox1.draw(g2d);
        g2d.rotate(Math.toRadians(45),  x + rayBox2.getSize()/2, y + rayBox2.getSize()/2);
        rayBox2.draw(g2d);
        g2d.setTransform(reset);
        sunCenter.draw(g2d);

    }

    /**
     * This method rotates the sun by adding the passed in value to the current value of rotation, which is used in g2d.rotate()
     * in the draw method.
     */
    public void rotateSun(double degrees){
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

     public double getWidth(){ return size; }

    /**
     * The getHeight() method simply returns the current width value of the object.
    */

    public double getHeight(){ return size; }



}
