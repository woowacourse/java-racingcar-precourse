package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    private static int finalFrontRunnerPosition = 0;
    private static ArrayList<Car> carsInGame;

    public static void play(Scanner scanner) {
        setGame(scanner);

        TrialProgression.trialProgress(numberOfTrial, carsInGame);
        finalFrontRunnerPosition = TrialProgression.getFrontRunnerPosition();

        WinnerAnnouncement.checkWinner(finalFrontRunnerPosition, carsInGame);
        WinnerAnnouncement.announce();
    }

    private static void setGame(Scanner scanner) {
        GameInformation.getUserInput(scanner);

        numberOfCarsInGame = GameInformation.getNumberOfCarsInGame();
        numberOfTrial = GameInformation.getNumberOfTrial();
        carsInGame = GameInformation.getCarsInGame();
    }
}
