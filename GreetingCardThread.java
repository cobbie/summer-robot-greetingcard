/**
 * This java class contains the class of the main thread, which contains the infinite looping of certain objects in the program.
 * It is placed in a while loop to keep the thread running.
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

import java.awt.Color;
public class GreetingCardThread extends Thread {

    private GreetingCardCanvas gcc;

    /**
     * The constructor of this class simply takes in the canvas object to be used, as all of the functionality in this thread
     * has to do with animating and manipulating objects in the canvas.
     * @param gcc
     */
    public GreetingCardThread(GreetingCardCanvas gcc){ this.gcc = gcc; }

    /**
     * The run method of Thread is overriden to give specific actions for this greeting card. Here, an infinite animation
     * is created: first, the suns and sunflowers rotate infinitely in opposite directions. Second, The leaves of the sunflowers
     * infinitely go up in down in opposite directions. When they reach the point where they are directly in front of each other,
     * one sunflower changes color at a time (they change alternately each time). Each iteration of this thread is set to 100 milliseconds.
     */
    @Override
    public void run(){

        try{
            while(true){

                gcc.getFirstSun().rotateSun(Math.toRadians(5));
                gcc.getSecondSun().rotateSun(Math.toRadians(-5));
                gcc.getFirstSunflower().rotateSunflowerHead(Math.toRadians(5));
                gcc.getSecondSunflower().rotateSunflowerHead(Math.toRadians(-5));

                if(gcc.getFirstSunflower().getLeaf1Y() < 40 && gcc.getFirstSunflower().getDirection1()){
                    gcc.getFirstSunflower().adjustLeaf1(2);
                    gcc.getFirstSunflower().adjustLeaf2(-2);

                    gcc.getSecondSunflower().adjustLeaf1(2);
                    gcc.getSecondSunflower().adjustLeaf2(-2);
                }
                else if (gcc.getFirstSunflower().getLeaf1Y() == 40 && gcc.getFirstSunflower().getDirection1()){
                    gcc.getFirstSunflower().reverseDirection();
                }
                else if(gcc.getFirstSunflower().getLeaf1Y()>0 && gcc.getFirstSunflower().getDirection1()==false){
                    gcc.getFirstSunflower().adjustLeaf1(-2);
                    gcc.getFirstSunflower().adjustLeaf2(2);
                    gcc.getSecondSunflower().adjustLeaf1(-2);
                    gcc.getSecondSunflower().adjustLeaf2(2);
                }
                else if(gcc.getFirstSunflower().getLeaf1Y()==0 && gcc.getFirstSunflower().getDirection1()==false){
                    gcc.getFirstSunflower().reverseDirection();

                }

                if(gcc.getFirstSunflower().getLeaf1Y() == 20 && gcc.getFirstSunflower().getDirection1()){
                    gcc.getFirstSunflower().adjustCenterColor(new Color(90,68,26));
                    gcc.getFirstSunflower().adjustPetalColor(new Color(238, 237, 138));

                    gcc.getSecondSunflower().adjustCenterColor(new Color(96,57,19));
                    gcc.getSecondSunflower().adjustPetalColor(new Color(255,242, 0));
                }
                else if (gcc.getFirstSunflower().getLeaf1Y() == 20 && gcc.getFirstSunflower().getDirection1()==false){
                    gcc.getFirstSunflower().adjustCenterColor(new Color(96,57,19));
                    gcc.getFirstSunflower().adjustPetalColor(new Color(255,242, 0));

                    gcc.getSecondSunflower().adjustCenterColor(new Color(90,68,26));
                    gcc.getSecondSunflower().adjustPetalColor(new Color(238, 237, 138));
                }

                gcc.repaint();
                Thread.sleep(100);
            }
        }
        catch(InterruptedException ex){
                    System.out.println("InterruptedException caught");
        }
    }
}
