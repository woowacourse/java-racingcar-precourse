package controller;

import view.Input;

import java.util.List;

public class Game {
    private int round;
    private List<String> cars;

    public Game() {
        this.cars = new Input().asCarNames();
        this.round = new Input().asRounds();
    }

    public void start() {
        
    }
}
