package racegame;

import java.util.Scanner;

import static racegame.Constant.OUTPUT_VIEW_REPETITION_COUNT;

public class RaceGameManager {

    private final Scanner scanner;
    private RaceGame raceGame;
    private int repetitionCount;

    public RaceGameManager(Scanner scanner) {
        this.scanner = scanner;
        raceGame = new RaceGame(scanner);

        playGame();
    }

    private void playGame(){
        raceGame.inputCarsName();
        repetitionCount = inputRepetitionCount();
        raceGame.playRounds(repetitionCount);
        raceGame.printWinners();
    }

    private int inputRepetitionCount(){
        OutputView.printNormal(OUTPUT_VIEW_REPETITION_COUNT);
        return InputView.getRepetitionCount(scanner);
    }

}
