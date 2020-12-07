package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final int MINIMUM_POSITION = 0;

    private List<Car> players;
    private List<String> winner = new ArrayList<>();

    public Winner(List<Car> players) {
        this.players = players;
        findWinnerName();
    }

    private void findWinnerName() {
        for (Car car : players) {
            addWinner(car);
        }
    }

    private void addWinner(Car car) {
        if (isWinner(car)) {
            car.addNameToWinner(winner);
        }
    }

    private boolean isWinner(Car car) {
        return car.isWinner(findHighestPosition());
    }

    private int findHighestPosition() {
        int highestPosition = MINIMUM_POSITION;
        for (Car car : players) {
            highestPosition = car.getPositionIfBiggerThan(highestPosition);
        }
        return highestPosition;
    }

    public String showWinnerName() {
        return String.join(", ", winner);
    }
}
