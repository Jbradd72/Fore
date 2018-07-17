package edu.byui.fore.fore;
import android.util.ArraySet;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import edu.byui.fore.fore.GameTypes;

import static edu.byui.fore.fore.GameTypes.*;

/**
 * encapsulates the idea of a game of golf. Contains the amount of time played, and the number of
 * holes with their associated data. Also contains the type of game.
 */
public class Game implements Serializable {
    Long startTime;
    Long endTime;
    private List<Hole> holes;
    GameTypes type;
    private Integer total;

    public Game() {
        total = 0;
        holes = new ArrayList<Hole>(18);
        for (int i = 0; i < 18; i++)
        {
            Hole temp = new Hole();
            holes.add(temp);
        }
        type = FULL_18;

    }

    public Game(GameTypes type){
        total = 0;
        for (int i = 0; i < 18; i++)
        {
            Hole temp = new Hole();
            holes.add(temp);
        }
        this.type = type;

       // time = (Time) new Date();
    }

    /**
     * starts the timer for the game
     */
    public void startTime(){this.startTime = System.currentTimeMillis();}

    /**
     * gets the amount of time from the system, and converts it from milliseconds to hours minutes
     * and seconds
     * @return a string that contains the amount of time passed in hours, minutes, and seconds
     */
    public String getTime(){
        this.endTime = System.currentTimeMillis();
        Long totalSeconds = (endTime - startTime) / 1000;
        Integer wholeHours = new Long(totalSeconds / 3600).intValue();
        Integer wholeMinutes = new Long((totalSeconds % 3600) / 60).intValue();
        Integer wholeSeconds = new Long((totalSeconds % 3600) % 60).intValue();
        String time = wholeHours.toString() + " Hours " + wholeMinutes.toString() + " Minutes " + wholeSeconds.toString() + " Seconds ";
        //String time = new Long(this.endTime - this.startTime).toString();
        return time;
    }

    /**
     * gets the holes from the game
     * @return a list of holes
     */
    public List<Hole> getHoles() {
        return holes;
    }

    /**
     * sets a list of holes equivalent to the given list of holes
     * @param holes a list of holes
     */
    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    /**
     * gets the type of game
     * @return the type of game
     */
    public GameTypes getType() {
        return type;
    }

    /**
     * sets the type of game to a given type
     * @param type
     */
    public void setType(GameTypes type) {
        this.type = type;
    }

    /**
     * sets the total score for the game
     * @param i the total for the game
     */
    public void setTotal(Integer i){this.total = i;}

    /**
     * gets the total score from the game
     * @return an Integer called total
     */
    public Integer getTotal(){return this.total;}
}
