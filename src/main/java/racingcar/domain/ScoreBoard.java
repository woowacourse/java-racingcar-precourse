package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
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

    public CarGroup getWinner(CarGroup group) {
        List<Car> cars = group.getCars();
        List<Car> winners = new ArrayList<>();
        int winnerScore = getWinnerScore(cars);

        cars.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .forEach(winners::add);

        return new CarGroup(winners);
    }

    private int getWinnerScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_GROUP.getMessage()));
    }
}
