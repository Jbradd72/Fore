package edu.byui.fore.fore;

import android.location.Location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import com.google.gson.Gson;

public class Course implements Serializable {
    Queue<Game> games;
    List<Integer> Pars;
    Game currentGame;
    String name;
    Double latitude;
    Double longitude;

    public Course(List<Integer> pars) {
        Pars = pars;
        currentGame = new Game();
        name = "Name not Set";
        games = new LinkedList<>();
        longitude = latitude = 0.0;
    }

    public Course(){
        this.name = "Name not Set";
        List<Integer> p = new ArrayList<>(18);
        Collections.fill(p, 0);
        Pars = p;
        currentGame = new Game();
        longitude = latitude = 0.0;
    }

    public float distanceTo(Course c){
        Location origin = new Location("");
        Location dest = new Location("");
        origin.setLatitude(this.latitude);
        origin.setLongitude(this.longitude);

        dest.setLongitude(c.longitude);
        dest.setLatitude(c.latitude);

        return origin.distanceTo(dest);
    }

    public Boolean equals(Course rh){
        return this.getName().equals(rh.getName());
    }

    public Queue<Game> getGames(){return games;}
    public void addCurrentGame(){
        if (games.size() < 10){
            games.add(currentGame);
        }
        else{
            games.poll();
            games.add(currentGame);
        }
    }

    public List<Integer> getPars() {
        return Pars;
    }

    public void setPars(List<Integer> pars) {
        Pars = pars;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void setName(String s){this.name = s;}
    public String getName(){return name;}


    public Float getHoleAverage(int index){
        float totalStrokes = 0;
        float numHoles = 0;
        if (games.size() > 0){
            for (Game game: games) {
                if(game.getType().equals(GameTypes.FULL_18) || game.getType().equals(currentGame.getType())) {
                    totalStrokes += game.getHoles().get(index).getStrokes();
                    numHoles++;
                }

            }
                return totalStrokes/numHoles;
        }

        return (float)0;


    }


}
