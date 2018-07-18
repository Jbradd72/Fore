package edu.byui.fore.fore;

import java.io.Serializable;

/**
 * Hole is the class representation of every single
 * hole within a course. The game class uses a list
 * of holes to keep track of the score.
 * @author Max Schuhmacher
 */

public class Hole implements Serializable {

    int strokes;

    Hole() {
        strokes = 0;
    }

    /**
     * gets the amount of strokes it took to get the ball into the hole
     * @return an int of the strokes
     */
    public int getStrokes() {
        return strokes;
    }

    /**
     * sets the strokes to a given int
     * @param strokes the number of strokes
     */
    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }
}
