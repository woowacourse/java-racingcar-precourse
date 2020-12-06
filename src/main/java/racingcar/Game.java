package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static int numberOfCarsInGame;
    private static int numberOfTrial;
    private static int frontRunnerPosition = 0;
    private static ArrayList<Car> carsInGame;
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자: ";

    public static void play(Scanner scanner) {
        setGameInformation(scanner);
        trialProgress();
        winnerAnnounce();
    }

    private static void setGameInformation(Scanner scanner) {
        GameInformation.getUserInput(scanner);
        numberOfCarsInGame = GameInformation.getNumberOfCarsInGame();
        numberOfTrial = GameInformation.getNumberOfTrial();
        carsInGame = GameInformation.getCarsArray();
    }

    private static void trialProgress() {
        for (int i = 0; i < numberOfTrial; i++) {
            singleTrial();
        }
    }

    private static void singleTrial() {
        for (Car car : carsInGame) {
            TrialProgression.moveOrStop(car);
            TrialProgression.printCarName(car);
            TrialProgression.printPosition(car);
            frontRunnerPosition = TrialProgression.checkFrontRunner(car, frontRunnerPosition);
        }
        System.out.println();
    }

    private static void winnerAnnounce() {
        System.out.print(WINNER_ANNOUNCEMENT);
        for (Car car : carsInGame) {
            if (car.getPosition() == frontRunnerPosition) {
                System.out.print(car.getName());
            }
        }
    }
}
