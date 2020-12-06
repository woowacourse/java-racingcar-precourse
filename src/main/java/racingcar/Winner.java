package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> players;
    public List<String> winner = new ArrayList<>();

    Winner(List<Car> players) {
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
        int highestPosition = 0;
        for (Car car : players) {
            highestPosition = car.getPositionIfBiggerThan(highestPosition);
        }
        return highestPosition;
    }
}
