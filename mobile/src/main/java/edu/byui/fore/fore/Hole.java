package edu.byui.fore.fore;

import java.io.Serializable;

public class Hole implements Serializable {

    int strokes;
    int Id;

    public Hole() {
        strokes = 0;
        Id = 0;
    }

    public Hole(int Id) {
        this.Id = Id;
        strokes = 0;
    }

    public int getStrokes() {
        return strokes;
    }

    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }
}
