/**
 * This java interface contains all of the required methods that each class that draws a shape/figure must contain.
 * These methods are important as they are what access and modify certain attributes that are needed so that
 * interaction between objects are possible.
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

public interface DrawingObject {
    void draw(Graphics2D g2d);
    void adjustX(double distance);
    void adjustY(double distance);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
}
