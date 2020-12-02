package racingcar.domain.race;

import static racingcar.domain.car.CarMoveStrategy.RANDOM_END_INCLUSIVE;
import static racingcar.domain.car.CarMoveStrategy.RANDOM_START_INCLUSIVE;
import static racingcar.domain.race.exception.CarNameLongerThanMaximumException.MAXIMUM_SIZE_OF_CAR_NAME;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMoveStrategy;
import racingcar.domain.car.NormalCarMoveStrategy;
import racingcar.domain.race.exception.AlreadyCompleteException;
import racingcar.domain.race.exception.CarNameLongerThanMaximumException;
import racingcar.domain.race.exception.EmptyCarNameInputException;
import racingcar.domain.race.exception.InvalidMovingCountInputException;
import utils.RandomUtils;

public class Race {

    private static final String DELIMITER = ",";

    private final List<Car> cars;
    private int movingCount;

    private Race(final List<Car> cars, final int movingCount) {
        this.cars = cars;
        this.movingCount = movingCount;
    }

    public static Race of(final String carNamesStr, final int movingCount) {
        return of(carNamesStr, movingCount, NormalCarMoveStrategy.getInstance());
    }

    public static Race of(final String carNamesStr, final int movingCount, final CarMoveStrategy carMoveStrategy) {
        validateMovingCount(movingCount);
        List<String> carNames = Arrays.asList(carNamesStr.split(DELIMITER));
        validateCarNames(carNamesStr, carNames);

        return of(carNames, movingCount, carMoveStrategy);
    }

    public static Race of(final List<String> carNames, final int movingCount,
        final CarMoveStrategy carMoveStrategy) {
        List<Car> cars = convertToCars(carNames, carMoveStrategy);
        return of(cars, movingCount);
    }

    public static Race of(final List<Car> cars, final int movingCount) {
        return new Race(cars, movingCount);
    }

    private static List<Car> convertToCars(final List<String> carNames,
        final CarMoveStrategy carMoveStrategy) {
        return carNames.stream()
            .map(carName -> convertToCar(carName, carMoveStrategy))
            .collect(Collectors.toList());
    }

    private static Car convertToCar(final String carName, final CarMoveStrategy carMoveStrategy) {
        String trimedCarName = carName.trim();
        validateCarName(trimedCarName);

        return Car.of(trimedCarName, carMoveStrategy);
    }

    private static void validateMovingCount(final int movingCount) {
        if (movingCount < 0) {
            throw new InvalidMovingCountInputException(movingCount);
        }
    }

    private static void validateCarNames(final String carNamesStr, final List<String> carNames) {
        if (carNamesStr.isEmpty() || carNames.isEmpty()) {
            throw new EmptyCarNameInputException(carNamesStr);
        }
    }

    private static void validateCarName(final String carStr) {
        if (carStr.isEmpty()) {
            throw new EmptyCarNameInputException(carStr);
        }

        if (carStr.length() > MAXIMUM_SIZE_OF_CAR_NAME) {
            throw new CarNameLongerThanMaximumException(carStr);
        }
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
