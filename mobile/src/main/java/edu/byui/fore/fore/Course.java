package edu.byui.fore.fore;

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

    public Course(List<Integer> pars) {
        Pars = pars;
        currentGame = new Game();
        name = "Name not Set";
        games = new LinkedList<>();
    }

    public Course(){
        this.name = "Name not Set";
        List<Integer> p = new ArrayList<>(18);
        Collections.fill(p, 0);
        Pars = p;
        currentGame = new Game();
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


    public Integer getHoleAverage(int index){
        int totalStrokes = 0;
        int numHoles = 0;
        if (games != null){
            for (Game game: games) {
                totalStrokes += game.getHoles().get(index).getStrokes();
                numHoles++;
            }

            return (totalStrokes / numHoles);
        }
        else{
            return 0;
        }

    }


}
