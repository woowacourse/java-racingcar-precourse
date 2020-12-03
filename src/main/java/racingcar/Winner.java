package racingcar;

import enums.GameHost;
import enums.GameProcess;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winners = new ArrayList<>();
    private static int winnerPosition = GameProcess.INITIAL_POSITION.getValue();

    public void findWinners(List<Car> carList) {
        setWinnerPosition(carList);
        for (Car car : carList) {
            addWinner(car);
        }
    }

    public void setWinnerPosition(List<Car> carList) {
        for (Car car : carList) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
    }

    public void addWinner(Car car) {
        if (isWinner(car)) {
            winners.add(car);
        }
    }

    public boolean isWinner(Car car) {
        return car.getPosition() == winnerPosition;
    }

    public String getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return String.join(GameHost.DELIMITER_TO_SPLIT_WINNERS.getMessage(), winnerNames);
    }
}
