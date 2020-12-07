package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleGame {
    private static ArrayList<Car> carsInGame;
    private static int numberOfTrial;
    private static int finalFrontRunnerPosition = 0;

    public static void play(Scanner scanner) {
        carsInGame = InputView.getUserCarInput(scanner);
        numberOfTrial = InputView.getUserTrialInput(scanner);

        TrialProgression.trialProgress(numberOfTrial, carsInGame);
        finalFrontRunnerPosition = TrialProgression.getFrontRunnerPosition();

        WinnerAnnouncement.checkWinner(finalFrontRunnerPosition, carsInGame);
        WinnerAnnouncement.announce();
    }

}
