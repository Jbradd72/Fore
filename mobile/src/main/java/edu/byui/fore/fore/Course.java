package edu.byui.fore.fore;

import java.util.Queue;
import java.util.Set;
import java.util.List;
import com.google.gson.Gson;

public class Course {
    Queue<Game> games;
    List<Integer> Pars;
    Game currentGame;

    public Course(List<Integer> pars) {
        Pars = pars;
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

    Gson g;


}
