package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class Simulator {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int THRESHOLD = 4;

    public static void simulateGame(Car[] cars, int stageCount) {
        UserScreen.showSimulateStart();

        for (int i = 0; i < stageCount; i++) {
            simulateStage(cars);
        }

        ArrayList<String> winners = getWinners(cars);
        UserScreen.showGameResult(winners);
    }

    public static ArrayList<String> getWinners(Car[] cars) {
        ArrayList<String> winners = new ArrayList<>();
        int farthestPosition = getFarthestPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == farthestPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public static int getFarthestPosition(Car[] cars) {
        int farthestPosition = 0;

        for (Car car : cars) {
            int position = car.getPosition();
            if (farthestPosition < position) {
                farthestPosition = position;
            }
        }

        return farthestPosition;
    }

    public static void simulateStage(Car[] cars) {
        for (Car car : cars) {
            int randomNumber = RandomUtils.nextInt(RANDOM_NUMBER_START, RANDOM_NUMBER_END);

            if (randomNumber >= THRESHOLD) {
                car.run();
            }
        }

        UserScreen.showStageResult(cars);
    }
}
