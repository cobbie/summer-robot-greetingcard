/**
 * This java class contains the drawing of the background, which is composed of the sky, sea, and sand. Each of these
 * portions of the whole background are made up of three squares containing the size of the width of the JFrame it
 * is passed in. As the drawings are made up of squares, the order they are instantiated and drawn matters.
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

public class Background implements DrawingObject{

    private double x;
    private double y;
    private double size;
    private Color skyColor;
    private Color seaColor;
    private Color sandColor;

    /**
     * The constructor of this background class only takes in the x position, y position, size (for the squares), and
     * colors per square.
     * @param x
     * @param y
     * @param size
     * @param skyColor
     * @param seaColor
     * @param sandColor
     */
    public Background(double x, double y, double size, Color skyColor, Color seaColor, Color sandColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.skyColor = skyColor;
        this.seaColor = seaColor;
        this. sandColor = sandColor;
    }

    /**
     * The draw method for this class instantiates and draws each square that makes up the background. The y values for the sea and
     * sand squares are adjusted to create the desired image of a beachfront looking into the horizon.
     */
    public void draw(Graphics2D g2d){

        Square sky = new Square(0,0,size,skyColor);
        Square sea = new Square(0, y +407.373, size, seaColor);
        Square sand = new Square(0,y + 563.649, size, sandColor);

        sky.draw(g2d);
        sea.draw(g2d);
        sand.draw(g2d);

    }
    /**
     * This method changes the three squares' colors to the passed in colors from where it is called.
     */

    public void changeBackground(Color color1, Color color2, Color color3){
        skyColor = color1;
        seaColor = color2;
        sandColor = color3;
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
     * the getY() method simply returns the current y value of the object.
     */
    public double getY() {
        return y;
    }

    /**
     * the getWidth() method simply returns the current width value of the object.
     */
    public double getWidth(){
        return size;
    }

    /**
     * the getHeight() method simply returns the current width value of the object.
     */
    public double getHeight(){
        return size;
    }


}