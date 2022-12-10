package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static racingcar.utils.ErrorMessage.INVALID_CAR_GROUP;

public class ScoreBoard {

    public ScoreBoard() {
    }

    public String toPositionMessage(CarGroup group) {
        List<Car> cars = group.getCars();
        return cars.stream()
                .map(car -> car.toMessage() + System.lineSeparator())
                .collect(Collectors.joining());
    }

    public String getWinner(CarGroup group) {
        List<Car> cars = group.getCars();
        StringJoiner winners = new StringJoiner(", ");
        int winnerScore = getWinnerScore(cars);

        cars.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .forEach(winners::add);

        return winners.toString();
    }

    private int getWinnerScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_GROUP.getMessage()));
    }
}
