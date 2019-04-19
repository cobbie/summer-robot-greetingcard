/**
 * This java class contains the JFrame where the canvas is placed. It is also here where the keybindings are given functionality
 * and binded to the frame to be able to perform actions upon pressing certain keys while the program is running.
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
 * https://dzone.com/articles/random-number-generation-in-java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GreetingCardFrame extends JFrame {
    private int width;
    private int height;
    private String title;
    private GreetingCardCanvas greetingCardCanvas;
    private JPanel contentPane;

    /**
     * The constructor for this class takes in the width, height, and title of the JFrame as parameters. It also instantiates
     * the Jframe and is casted as a JPanel to make the use of key bindings possible.
     * @param width
     * @param height
     * @param title
     */
    public GreetingCardFrame(int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
        contentPane = (JPanel) getContentPane();
        contentPane.setFocusable(true);
    }

    /**
     * This method sets up the frame to be used by adding in the greeting card canvas and setting the necessary
     * configurations.
     */
    public void setUpFrame(){
        setSize(width,height);
        greetingCardCanvas = new GreetingCardCanvas(width, height);
        setTitle(title);
        contentPane.add(greetingCardCanvas, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Returns the greetingCardCanvas object.
     * @return greetinCardCanvas
     */
    public GreetingCardCanvas getGCC(){
        return greetingCardCanvas;
    }

    /**
     * This method creates the keybindings by making use of ActionMap and InputMap objects along with AbstractAction objects.
     * The AbstractAction objects create the actions to be performed, which are then passed into the ActionMap objects. These
     * get triggered through the InputMap objects.
     */
    public void addKeyBindings(){
    ActionMap am = contentPane.getActionMap();
    InputMap im = contentPane.getInputMap();

        /**
         * This AbstractAction adjusts the robot seen on the greeting card to move 5 pixels to the left.
         */
    AbstractAction moveLeft = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            greetingCardCanvas.getRobot().adjustX(-5);
        }
    };

/**
 * This AbstractAction adjusts the robot seen on the greeting card to move 5 pixels to the right.
 */
    AbstractAction moveRight = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            greetingCardCanvas.getRobot().adjustX(5);
        }
    };

        /**
         * This AbstractAction adjusts the arm of the robot seen on the greeting card to rotate to the left, until it
         * reaches its limit of -85 degrees. It also changes the robot's inner body color each time it moves the arm.
         */
    AbstractAction moveArmUp = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(greetingCardCanvas.getRobot().getRotation() > Math.toRadians(-85) )
                greetingCardCanvas.getRobot().moveArmUp(Math.toRadians(-5));
            greetingCardCanvas.getRobot().changeInnerBodyColor((int)generateRandomInt(0,122), (int)generateRandomInt(0,122), (int)generateRandomInt(0,122));

        }
    };

        /**
         * This AbstractAction adjusts the arm of the robot seen on the greeting card to rotate to the right, until it
         * reaches its limit of 85 degrees. It also changes the robot's inner body color each time it moves the arm.
         */
        AbstractAction moveArmDown= new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(greetingCardCanvas.getRobot().getRotation() < Math.toRadians(85) )
                    greetingCardCanvas.getRobot().moveArmUp(Math.toRadians(5));
                greetingCardCanvas.getRobot().changeInnerBodyColor((int)generateRandomInt(122,255), (int)generateRandomInt(122,255), (int)generateRandomInt(122,255));
            }
        };

        /**
         * This AbstractAction changes the greeting card's background by creating a new color that makes use of three
         * random values from 0-120 that makes up for its RGB values. These are created using the generateRandomInt method.
         */
        AbstractAction changeBGColor = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greetingCardCanvas.getBackgroundObject().changeBackground(
                        new Color((int) generateRandomInt(0,120), (int) generateRandomInt(0,120), (int) generateRandomInt(0,120)),
                        new Color((int) generateRandomInt(0,120), (int) generateRandomInt(0,120), (int) generateRandomInt(0,120)),
                        new Color((int) generateRandomInt(0,120), (int) generateRandomInt(0,120), (int) generateRandomInt(0,120))

                );
            }
        };

    am.put("moveLeft", moveLeft);
    am.put("moveRight", moveRight);
    am.put("moveArmUp", moveArmUp);
    am.put("moveArmDown", moveArmDown);
    am.put("changeBGColor", changeBGColor);
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false),"moveLeft");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false),"moveRight");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false),"moveArmUp");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false), "moveArmDown");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "changeBGColor");

    }

    /**
     * This method generates a random integer based on the passed in minimum and maximum values. The int type
     * is taken through casting.
     * @param min
     * @param max
     * @return x
     */
    public static double generateRandomInt(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

}
