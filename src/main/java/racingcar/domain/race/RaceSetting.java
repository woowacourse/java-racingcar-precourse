package racingcar.domain.race;

import static racingcar.domain.race.exception.CarNameLongerThanMaximumException.MAXIMUM_SIZE_OF_CAR_NAME;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMoveStrategy;
import racingcar.domain.car.NormalCarMoveStrategy;
import racingcar.domain.race.exception.CarNameLongerThanMaximumException;
import racingcar.domain.race.exception.EmptyCarNameInputException;
import racingcar.domain.race.exception.InvalidMovingCountInputException;

public class RaceSetting {

    private static final String DELIMITER = ",";

    public static Race makeRace(final String carNamesStr, int movingCount) {
        List<Car> cars = convertToCars(carNamesStr);
        return makeRace(cars, movingCount);
    }

    public static Race makeRace(final String carNamesStr, int movingCount, final CarMoveStrategy carMoveStrategy) {
        List<Car> cars = convertToCars(carNamesStr, carMoveStrategy);
        return makeRace(cars, movingCount);
    }

    private static Race makeRace(List<Car> cars, int movingCount) {
        validateMovingCount(movingCount);
        return Race.of(cars, movingCount);
    }

    private static List<Car> convertToCars(final String carNamesStr) {
        return convertToCars(carNamesStr, NormalCarMoveStrategy.getInstance());
    }

    private static List<Car> convertToCars(final String carNamesStr, final CarMoveStrategy carMoveStrategy) {
        List<String> carNames = Arrays.asList(carNamesStr.split(DELIMITER));
        validateCarNames(carNamesStr, carNames);

        return convertToCars(carNames, carMoveStrategy);
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

    private static void validateMovingCount(final int movingCount) {
        if (movingCount < 0) {
            throw new InvalidMovingCountInputException(movingCount);
        }
    }
}
