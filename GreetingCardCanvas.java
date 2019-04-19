/**
 * This java class contains the canvas where the drawings are made. It is in this class where all of the drawing
 * objects are made and drawn using an arrayList.
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
 * https://www.javaworld.com/article/2076869/drawing-text-is-easy-with-three-java-classes.html
 * https://www.oreilly.com/library/view/java-awt-reference/9781565922402/06_chapter-03.html
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class GreetingCardCanvas extends JComponent {

    private int width;
    private int height;
    private Sun firstSun;
    private Sun secondSun;
    private Graphics2D g2d;
    private Sunflower sunflower1;
    private Sunflower sunflower2;
    private ArrayList<DrawingObject> drawingObjects;
    private Cloud cloud1;
    private Cloud cloud2;
    private Robot robot;
    private Background background;
    private Tree tree;
    private IceCream iceCream;

    /**
     * The constructor for this class only takes in the width and height as parameters (which are then passed to the corresponding
     * fields), but instantiates all of the shapes that are seen in the greeting card. It adds all of these shapes to an
     * arrayList, which will later be used to help in simplifying the drawing of the objects.
     * @param width
     * @param height
     */


    public GreetingCardCanvas (int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        drawingObjects = new ArrayList<>();
        background = new Background(0,0, 1024, new Color(177,216,243), new Color(131,188,230),  new Color(255,209, 118));
        firstSun = new Sun(605, 46, 71, new Color(255,242,0), new Color(255,222,23));
        secondSun = new Sun(firstSun.getX()+200, firstSun.getY(), 71, new Color(255,222,23), new Color(255,242,0));
        cloud1 = new Cloud(66, 45, 204, 54);
        cloud2 = new Cloud(259,119, 204,54);
        sunflower1 = new Sunflower(216, 480, 42, 60,new Color(96,57,19), new Color(255,242, 0));
        sunflower2 = new Sunflower(738, 480, 42, 60, new Color(96,57,19), new Color(255,242, 0));
        robot = new Robot(372, 260,257.326, 429.288, new Color(198, 178, 179));
        tree = new Tree(15,300,288, 200);
        iceCream = new IceCream(sunflower2.getX() + 200,sunflower2.getY()+60,50,100);


        drawingObjects.add(background);
        drawingObjects.add(robot);
        drawingObjects.add(firstSun);
        drawingObjects.add(secondSun);
        drawingObjects.add(cloud1);
        drawingObjects.add(cloud2);
        drawingObjects.add(sunflower1);
        drawingObjects.add(sunflower2);
        drawingObjects.add(tree);
        drawingObjects.add(iceCream);
    }

    /**
     *The paintComponent method of the JComponent class is overridden to perform the desired actions to create the
     * greeting card of this project. It first casts the Graphics object to a Graphics2D object. It then makes use of
     * a for loop and an AffineTransform object to draw each object according to their own transformations.
     * afterwards, the Graphics2D object is then used to create the text seen on the greeting card.
     */
    @Override
    protected void paintComponent (Graphics g){
        g2d = (Graphics2D) g;

        for(int i=0; i< drawingObjects.size(); i++){
            AffineTransform reset = g2d.getTransform();
            drawingObjects.get(i).draw(g2d);
            g2d.setTransform(reset);
        }

        g2d.setColor(Color.YELLOW);
        g2d.setFont(new Font("Helvetica", Font.ITALIC, 30));
        g2d.drawString("trippyBot in summer", 600,200);
    }

    /**
     * Returns the background object.
     * @return background
     */
    public Background getBackgroundObject(){
        return background;
    }

    /**
     * Returns the firstSun object.
     * @return firstSun
     */
    public Sun getFirstSun(){
        return firstSun;
    }

    /**
     * Returns the secondSun object.
     * @return secondSUn
     */
    public Sun getSecondSun(){
        return secondSun;
    }

    /**
     * Returns the sunflower1 object
     * @return sunflower1
     */
    public Sunflower getFirstSunflower(){
        return sunflower1;
    }

    /**
     * Returns the sunflower2 object.
     * @return sunflower2
     */
    public Sunflower getSecondSunflower(){
        return sunflower2;
    }

    /**
     * Returns the cloud1 object.
     * @return cloud1
     */
    public Cloud getFirstCloud(){
        return cloud1;
    }

    /**
     * Returns the cloud2 object.
     * @return cloud2
     */
    public Cloud getSecondCloud(){
        return cloud2;
    }

    /**
     * Returns the robot object.
     * @return robot
     */
    public Robot getRobot(){
        return robot;
    }

}
