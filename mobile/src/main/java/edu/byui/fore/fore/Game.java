package edu.byui.fore.fore;
import java.sql.Time;
import java.util.Date;
import java.util.Set;
import edu.byui.fore.fore.GameTypes;

import static edu.byui.fore.fore.GameTypes.*;

public class Game {
    Time time;
    Set<Hole> holes;
    GameTypes type;

    public Game() {
        for (int i = 0; i < 18; i++)
        {
            Hole temp = new Hole();
            holes.add(temp);
        }
        type = FULL_18;

        time = (Time) new Date();
    }

    public Game(GameTypes type){
        for (int i = 0; i < 18; i++)
        {
            Hole temp = new Hole();
            holes.add(temp);
        }
        this.type = type;

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

    public GameTypes getType() {
        return type;
    }

    public void setType(GameTypes type) {
        this.type = type;
    }
}
