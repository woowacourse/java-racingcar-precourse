package racingcar.domain;

import racingcar.support.CarMoveFlagGenerator;
import racingcar.support.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.ErrorMessage.GROUP_CANNOT_HAVE_DUPLICATED_CAR;
import static racingcar.utils.ErrorMessage.INVALID_CAR_GROUP;

public class CarGroup {

    private static final String WINNER_DELIMITER = ", ";
    
    private final RandomNumberGenerator flagGenerator;
    private final List<Car> carGroup;

    public CarGroup(List<Car> cars) {
        this.flagGenerator = new CarMoveFlagGenerator();
        validateCarGroup(cars);
        this.carGroup = cars;
    }

    private void validateCarGroup(List<Car> cars) {
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException(GROUP_CANNOT_HAVE_DUPLICATED_CAR.getMessage());
        }
    }

    private boolean isDuplicate(List<Car> cars) {
        long distinctCars = cars.stream()
                .distinct()
                .count();

        return cars.size() != distinctCars;
    }

    public void moveAll() {
        carGroup.stream()
                .filter(car -> isMove())
                .forEach(Car::move);
    }

    private boolean isMove() {
        return flagGenerator.generate();
    }

    public String toProgressMessage() {
        return carGroup.stream()
                .map(Car::toMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String toWinnerMessage() {
        int winnerScore = getWinnerScore();

        return carGroup.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private int getWinnerScore() {
        return carGroup.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_GROUP.getMessage()));
    }
}
