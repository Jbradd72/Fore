package edu.byui.fore.fore;

public class Hole {

    int strokes;
    Integer par;
    int Id;

    public Hole() {
        strokes = 0;
        par = 0;
        Id = 0;
    }

    public Hole(int Id) {
        this.Id = Id;
        strokes = 0;
        par = 0;
    }

    public int getStrokes() {
        return strokes;
    }

    public void setStrokes(int strokes) {
        this.strokes = strokes;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public void incrementStrokes() {
        strokes++;
    }
}
