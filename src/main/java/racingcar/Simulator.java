package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class Simulator {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int THRESHOLD = 4;

    private Car[] cars;
    private int stageCount;

    public Simulator(Car[] cars, int stageCount) {
        this.cars = cars;
        this.stageCount = stageCount;
    }

    public void simulateGame() {
        UserScreen.showSimulateStart();

        for (int i = 0; i < this.stageCount; i++) {
            simulateStage();
        }

        ArrayList<String> winners = getWinners();
        UserScreen.showGameResult(winners);
    }

    private ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int farthestPosition = getFarthestPosition();

        for (Car car : this.cars) {
            if (car.getPosition() == farthestPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getFarthestPosition() {
        int farthestPosition = 0;

        for (Car car : this.cars) {
            int position = car.getPosition();
            if (farthestPosition < position) {
                farthestPosition = position;
            }
        }

        return farthestPosition;
    }

    private void simulateStage() {
        for (Car car : this.cars) {
            int randomNumber = RandomUtils.nextInt(RANDOM_NUMBER_START, RANDOM_NUMBER_END);

            if (randomNumber >= THRESHOLD) {
                car.run();
            }
        }

        UserScreen.showStageResult(this.cars);
    }
}
