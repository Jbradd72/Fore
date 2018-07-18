package edu.byui.fore.fore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static edu.byui.fore.fore.GameTypes.*;

public class Game implements Serializable {
    private Long startTime;
    private Long endTime;
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

    }

    public void startTime(){this.startTime = System.currentTimeMillis();}

    public String getTime(){
        this.endTime = System.currentTimeMillis();
        Long totalSeconds = (endTime - startTime) / 1000;
        Integer wholeHours = new Long(totalSeconds / 3600).intValue();
        Integer wholeMinutes = new Long((totalSeconds % 3600) / 60).intValue();
        Integer wholeSeconds = new Long((totalSeconds % 3600) % 60).intValue();
        String time = wholeHours.toString() + " Hours " + wholeMinutes.toString() + " Minutes " + wholeSeconds.toString() + " Seconds ";
        return time;
    }

    public List<Hole> getHoles() {
        return holes;
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
