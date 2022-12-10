package racingcar.domain;

import racingcar.support.CarMoveFlagGenerator;
import racingcar.support.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.ErrorMessage.INVALID_CAR_GROUP;

public class CarGroup {

    private final RandomNumberGenerator flagGenerator;
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.flagGenerator = new CarMoveFlagGenerator();
        this.cars = cars;
    }

    public void moveAll() {
        cars.stream()
                .filter(car -> isMove())
                .forEach(Car::move);
    }

    private boolean isMove() {
        return flagGenerator.generate();
    }

    public String toProgressMessage() {
        return cars.stream()
                .map(Car::toMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String toWinnerMessage() {
        int winnerScore = getWinnerScore();

        return cars.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getWinnerScore() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_GROUP.getMessage()));
    }

}
