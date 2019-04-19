/**
 * This java class contains the drawing of the Sunflower head. It uses the Square object to create its petals and rotation
 * to create the petal shape. Although the canvas displays this object to be rotating, it is actually in the Sunflower
 * class where this is made possible.
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
import java.util.ArrayList;


public class SunflowerHead implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color centerColor;
    private Color petalColor;

    /**
     * The constructor of this SunflowerHead class takes in the x coordinate, the y coordinate, the width and height, and the
     * color to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     */

    /**
     * The constructor of this SunflowerHead class takes in the x coordinate, the y coordinate, the width and height, and the
     * color to be used for the shape as parameters. It then passes these in to the corresponding fields of the shape.
     * @param x
     * @param y
     * @param size
     * @param centerColor
     * @param petalColor
     */
    public SunflowerHead(double x, double y, double size, Color centerColor, Color petalColor){
        this.x = x;
        this.y = y;
        this.size = size;
        this.centerColor = centerColor;
        this.petalColor = petalColor;
    }

    /**
     * The draw method for this class instantiates multiple Square objects. It then passed them into an ArrayList.
     * The fields of this class are then passed in to these objects to create the desired shape,
     * and the Graphics2D object is then used create the drawing through a for loop.
     * Transformations such as rotate are also done for animation.
     */
    public void draw(Graphics2D g2d){

        ArrayList<Square> petalsList = new ArrayList<>();
        AffineTransform reset = g2d.getTransform();
        Square petals1 = new Square(x,y,size, petalColor);
        Square petals2 = new Square(x,y,size, petalColor);
        Square petals3 = new Square(x,y,size, petalColor);
        Square petals4 = new Square(x,y,size, petalColor);
        Square petals5 = new Square(x,y,size, petalColor);
        Square petals6 = new Square(x,y,size, petalColor);
        petalsList.add(petals1);
        petalsList.add(petals2);
        petalsList.add(petals3);
        petalsList.add(petals4);
        petalsList.add(petals5);
        petalsList.add(petals6);

       for(int i=0; i< petalsList.size(); i++){
           petalsList.get(i).draw(g2d);
          g2d.rotate(Math.toRadians(15), x + petalsList.get(i).getSize()/2, y+petalsList.get(i).getSize()/2);

        }
        g2d.setColor(centerColor);

        g2d.fillOval((int)x,(int)y,(int)size,(int)size);
        g2d.setTransform(reset);



    }

    /**
     * This method returns the size value of the object, which is the same as its width and height values, given
     * that these values in this shape specifically is primarily defined by the squares which serve as petals.
     */
    public double getSize(){
        return size;
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
      * The adjustY() method does the same thing as adjustX(), but for the object's y value.
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
    public double getWidth(){ return size; }

    /**
     * The getHeight() method simply returns the current width value of the object.
    */

    public double getHeight(){ return size; }
}
