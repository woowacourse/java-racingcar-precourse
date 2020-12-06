package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class TrialProgression {
    private static int frontRunnerPosition = 0;

    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_FORWARD_POINT = 4;
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
            moveOrStop(car);
            printCarName(car);
            printPosition(car);
            checkFrontRunner(car);
        }
        System.out.println();
    }

    private static void moveOrStop(Car car) {
        int progressCheck = RandomUtils.nextInt(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (progressCheck >= MOVE_FORWARD_POINT) {
            car.moveForward();
        }
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
