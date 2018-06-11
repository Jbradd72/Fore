package edu.byui.fore.fore;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Game {
    Time time;
    Set<Hole> holes;
    int type;

    public Game() {
        for (int i = 0; i < 18; i++)
        {
            Hole temp = new Hole();
            holes.add(temp);
        }
        type = 0;

        time = (Time) new Date();
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<Hole> getHoles() {
        return holes;
    }

    public void setHoles(Set<Hole> holes) {
        this.holes = holes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
