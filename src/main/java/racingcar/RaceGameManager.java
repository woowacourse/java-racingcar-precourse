package racingcar;

import java.util.Scanner;

public class RaceGameManager {

    private Scanner scanner;
    private RaceGame raceGame;
    private int repetitionCount;

    public RaceGameManager(Scanner scanner) {
        this.scanner = scanner;
        raceGame = new RaceGame(scanner);

        playGame();
    }

    private void playGame(){
        raceGame.inputCarsName();
    }

    private void inputRepetitionCount(){

    }

}
