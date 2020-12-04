package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;
    private int firstPosition;

    public Cars(List<Car> cars) {
        this.cars = cars;
        firstPosition = 0;
    }

    public void tryMoveAll() {
        cars.stream().forEach(Car::tryMove);
        updateFirstPosition();
    }

    public void printCarsPosition() {
        cars.stream().forEach(Car::printPosition);
    }

    private void updateFirstPosition() {
        boolean needToUpdate = cars.stream()
                .anyMatch(car -> car.isFartherThan(this.firstPosition));

        if (needToUpdate) {
            firstPosition++;
        }
    }

    public String getWinnerNames() {
        return cars.stream()
                .map(car -> car.getNameIfWinner(firstPosition))
                .filter(name -> name != null)
                .collect(Collectors.joining(NAME_DELIMITER));
    }
}
