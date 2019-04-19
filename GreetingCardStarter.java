/**
 * This java class contains the main method. It instantiates three objects: GreetingCardFrame, GreetingCardThread,
 * and GreetingCard2.
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

public class GreetingCardStarter {
    /**
     * After instantiating the GreetingCardFrame object, two methods are called: setUpFrame() and addKeyBindings(). Here,
     * the frame and keybindings are created. Afterwards, the two thread objects are instantiated, and .start() is called, where
     * their infinite loops run.
     */
    public static void main(String[] args) {
        GreetingCardFrame gcf = new GreetingCardFrame(1024,768, "Animated Java Greeting Card");
        gcf.setUpFrame();
        gcf.addKeyBindings();
        GreetingCardThread mainThread = new GreetingCardThread(gcf.getGCC());
        mainThread.start();
        GreetingCardThread2 st = new GreetingCardThread2(gcf.getGCC());
        st.start();

    }
}
