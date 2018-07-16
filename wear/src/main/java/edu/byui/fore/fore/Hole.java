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

    public Hole() {
        strokes = 0;
    }

    public int getStrokes() {
        return strokes;
    }

    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }
}
