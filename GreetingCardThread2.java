/**
 * This java class contains the second thread, which is where the loop of other objects are contained. This second thread
 * is different from the first and is necessary because the sleep time (time between iterations) is different from
 * the first thread.
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

public class GreetingCardThread2 extends Thread {

    private GreetingCardCanvas gcc;

    /**
     * The constructor of this class simply takes in the canvas object to be used, as all of the functionality in this thread
     * has to do with animating and manipulating objects in the canvas.
     * @param gcc
     */
    public GreetingCardThread2(GreetingCardCanvas gcc){
        this.gcc = gcc;
    }

    /**
     * The run method of Thread has been overridden to create a part of the animation of this greeting card.
     * Here, the two clouds sway right and left alternately. The thread is set to iterate every 500 milliseconds.
     */
    @Override
    public void run(){


            try{
                while(true){


                    if(gcc.getFirstCloud().getRotateLeft() == true){
                        gcc.getFirstCloud().rotateCloud(Math.toRadians(15));
                        gcc.getFirstCloud().reverseRotationDir();
                    }
                    else{
                        gcc.getFirstCloud().rotateCloud(Math.toRadians(-15));
                        gcc.getFirstCloud().reverseRotationDir();
                    }

                    if(gcc.getSecondCloud().getRotateLeft() == true){
                        gcc.getSecondCloud().rotateCloud(Math.toRadians(-15));
                        gcc.getSecondCloud().reverseRotationDir();
                    }
                    else{
                        gcc.getSecondCloud().rotateCloud(Math.toRadians(15));
                        gcc.getSecondCloud().reverseRotationDir();
                    }

                    Thread.sleep(500);
                    }

            }
            catch(InterruptedException ex){
                System.out.println("error");
            }
    }
}
