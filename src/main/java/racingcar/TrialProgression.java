package racingcar;

import utils.RandomUtils;

public class TrialProgression {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_FORWARD_POINT = 4;
    private static final String CAR_NAME_PRINT_FORMAT = " : ";
    private static final String POSITION_INDICATOR = "-";

    public static void moveOrStop(Car car) {
        int progressCheck = RandomUtils.nextInt(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        if (progressCheck >= MOVE_FORWARD_POINT) {
            car.moveForward();
        }
    }

    public static void printCarName(Car car) {
        String carName = car.getName();
        System.out.print(carName + CAR_NAME_PRINT_FORMAT);
    }

    public static void printPosition(Car car) {
        int carPosition = car.getPosition();
        String printCurrentPosition = "";
        for (int i = 0; i < carPosition; i++) {
            printCurrentPosition += POSITION_INDICATOR;
        }
        System.out.println(printCurrentPosition);
    }

    public static int checkFrontRunner(Car car, int frontRunnerPosition) {
        int carPosition = car.getPosition();
        if (carPosition > frontRunnerPosition) {
            return carPosition;
        }
        return frontRunnerPosition;
    }
}
