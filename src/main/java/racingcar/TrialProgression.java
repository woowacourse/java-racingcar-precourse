package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class TrialProgression {
    private static int frontRunnerPosition = 0;

    private static final String CAR_NAME_PRINT_FORMAT = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String TRIAL_RESULT = "실행 결과";

    public static void trialProgress(int numberOfTrial, ArrayList<Car> carsInGame) {
        System.out.println();
        System.out.println(TRIAL_RESULT);
        for (int i = 0; i < numberOfTrial; i++) {
            singleTrial(carsInGame);
        }
    }

    public static int getFrontRunnerPosition() {
        return frontRunnerPosition;
    }

    private static void singleTrial(ArrayList<Car> carsInGame) {
        for (Car car : carsInGame) {
            car.moveOrStop();
            printCarName(car);
            printPosition(car);
            checkFrontRunner(car);
        }
        System.out.println();
    }


    private static void printCarName(Car car) {
        String carName = car.getName();
        System.out.print(carName + CAR_NAME_PRINT_FORMAT);
    }

    private static void printPosition(Car car) {
        int carPosition = car.getPosition();
        StringBuilder printCurrentPosition = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            printCurrentPosition.append(POSITION_INDICATOR);
        }
        System.out.println(printCurrentPosition.toString());
    }

    private static void checkFrontRunner(Car car) {
        int carPosition = car.getPosition();
        if (carPosition > frontRunnerPosition) {
            frontRunnerPosition = carPosition;
        }
    }
}
