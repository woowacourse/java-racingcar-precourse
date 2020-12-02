package racingcar.domain.race;

import static racingcar.domain.car.CarMoveStrategy.RANDOM_END_INCLUSIVE;
import static racingcar.domain.car.CarMoveStrategy.RANDOM_START_INCLUSIVE;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.race.exception.AlreadyCompleteException;
import utils.RandomUtils;

public class Race {

    private final List<Car> cars;
    private int movingCount;

    private Race(final List<Car> cars, final int movingCount) {
        this.cars = cars;
        this.movingCount = movingCount;
    }

    public static Race of(final List<Car> cars, final int movingCount) {
        return new Race(cars, movingCount);
    }

    public void move() {
        if (isComplete()) {
            throw new AlreadyCompleteException();
        }

        this.cars.forEach(this::move);
        this.movingCount--;
    }

    private void move(final Car car) {
        int randomValue = RandomUtils.nextInt(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
        car.move(randomValue);
    }

    public boolean isComplete() {
        return this.movingCount == Car.DEFAULT_POSITION;
    }

    public List<Car> getFirstPlaceCars() {
        final int firstPlacePosition = getFirstPlacePosition();

        return this.cars.stream()
            .filter(car -> car.getPosition() == firstPlacePosition)
            .collect(Collectors.toList());
    }

    private int getFirstPlacePosition() {
        return this.cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(Car.DEFAULT_POSITION);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
