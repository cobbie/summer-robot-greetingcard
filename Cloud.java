/**
 * This java class contains the drawing of the Cloud shape. This is done through drawing four Oval objects and placing
 * them in specific locations relative to where the shape is placed on the canvas.
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
public class Cloud implements DrawingObject {

    private double x;
    private double y;
    private double width;
    private double height;
    private double rotation;
    private boolean rotateLeft;
    private Color color;
    private Oval oval1;
    private Oval oval2;
    private Oval oval3;
    private Oval oval4;

    /*
     * The constructor of this Cloud class takes in the x coordinate, the y coordinate, and the width and height as parameters
     * and accordingly passes these values to the corresponding fields. Additionally, it assigns initial values for rotateLeft,
     * rotation, and color, as these values will always stay the same for when they are first instantiated. The rotation
     * and rotateLeft values change accordingly when interacting with other classes, but will never be passed in as parameters.
    */

    /**
     * The constructor of this Cloud class takes in the x coordinate, the y coordinate, and the width and height as parameters
     * and accordingly passes these values to the corresponding fields. Additionally, it assigns initial values for rotateLeft,
     * rotation, and color, as these values will always stay the same for when they are first instantiated. The rotation
     * and rotateLeft values change accordingly when interacting with other classes, but will never be passed in as parameters.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Cloud(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height = height;
        rotation = 0;
        rotateLeft = true;
        color = Color.WHITE;
    }

    /**
     * The draw method for this class instantiates and draws multiple oval objects that makes up the cloud shape.
     * The fields of this object are then passed in to these objects (with some being
     * modified) to create the desired shape, and the Graphics2D object is then used to rotate and fill the cloud to create the drawing.
     */
    public void draw(Graphics2D g2d){
        oval1 = new Oval(x, y+height*.25, width *.5, height,color);
        oval2 = new Oval(x + width * .4, y + height*.2, width *.5, height*.85, color);
        oval3 = new Oval(x + width *.1, y+height*.85, width*.5,height*.85, color);
        oval4 = new Oval(x + width *.5, y+height*.8, width*.5,height*.85, color);

        g2d.rotate(rotation, x + width/2, y + height/2);
        oval1.draw(g2d);
        oval2.draw(g2d);
        oval3.draw(g2d);
        oval4.draw(g2d);

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

    /**
     * This method returns the boolean value rotateLeft, which dictates whether the Cloud is currently rotated left or not.
     */
    public boolean getRotateLeft() { return rotateLeft; }

    /**
     * This method rotates the cloud by changing the rotation field according to what value is passed in.
     */
    public void rotateCloud(double degrees){
        rotation = degrees;
    }

    /**
     * This method changed the boolean value of rotateLeft to what it is not, therefore always changing the direction
     * of the rotation to either right or left.
     */
    public void reverseRotationDir(){ rotateLeft = !rotateLeft; }
}
