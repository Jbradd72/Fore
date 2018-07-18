package edu.byui.fore.fore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Pars = new ArrayList<>(18);
        for (int i = 0; i < 18; i++){
            Pars.add(0);
        }
        currentGame = new Game();
        games = new LinkedList<>();
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


    public Float getHoleAverage(int index, int currentScore){
        float totalStrokes = currentScore;
        float numHoles = 1;
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
