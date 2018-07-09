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

    public void startTime(){this.startTime = System.currentTimeMillis();}

    public Integer[] getTime(){
        this.endTime = System.currentTimeMillis();
        Long totalSeconds = 1000 * (endTime - startTime);
        Integer wholeHours = new Long(totalSeconds / 3600).intValue();
        Integer wholeMinutes = new Long((totalSeconds % 3600) / 60).intValue();
        Integer wholeSeconds = new Long((totalSeconds % 3600) % 60).intValue();

        Integer time[] = new Integer[3];
        time[0] = wholeHours;
        time[1] = wholeMinutes;
        time[2] = wholeSeconds;


        return time;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public GameTypes getType() {
        return type;
    }

    public void setType(GameTypes type) {
        this.type = type;
    }

    public void setTotal(Integer i){this.total = i;}

    public Integer getTotal(){return this.total;}
}
