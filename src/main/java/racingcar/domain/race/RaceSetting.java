package racingcar.domain.race;

import static racingcar.domain.race.exception.CarNameLongerThanMaximumException.MAXIMUM_SIZE_OF_CAR_NAME;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMoveStrategy;
import racingcar.domain.car.NormalCarMoveStrategy;
import racingcar.domain.race.exception.CarNameLongerThanMaximumException;
import racingcar.domain.race.exception.EmptyCarNameInputException;
import racingcar.domain.race.exception.InvalidMovingCountInputException;

public class RaceSetting {

    public static final String DELIMITER = ",";
    private static final String DUPLICATED_NAME = "%s(%d)";

    public static Race makeRace(List<Car> cars, int movingCount) {
        validateMovingCount(movingCount);
        return Race.of(cars, movingCount);
    }

    public static List<Car> convertToCars(final String carNamesStr) {
        return convertToCars(carNamesStr, NormalCarMoveStrategy.getInstance());
    }

    public static List<Car> convertToCars(final String carNamesStr, final CarMoveStrategy carMoveStrategy) {
        List<String> carNames = Arrays.stream(carNamesStr.split(DELIMITER))
            .map(carName -> {
                carName = carName.trim();
                validateCarName(carName);
                return carName;
            })
            .collect(Collectors.toList());

        validateCarNames(carNamesStr, carNames);
        addCountingNumberToBackOfDuplicateName(carNames);

        return convertToCars(carNames, carMoveStrategy);
    }

    private static List<Car> convertToCars(final List<String> carNames, final CarMoveStrategy carMoveStrategy) {
        return carNames.stream()
            .map(carName -> Car.of(carName, carMoveStrategy))
            .collect(Collectors.toList());
    }

    private static void validateCarNames(final String carNamesStr, final List<String> carNames) {
        if (carNamesStr.isEmpty() || carNames.isEmpty() || carNamesStr.split(DELIMITER).length == 0) {
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

    private static void addCountingNumberToBackOfDuplicateName(List<String> carNames) {
        Map<String, Integer> counter = new HashMap<>();

        for (String carName : carNames) {
            if (counter.containsKey(carName)) {
                counter.put(carName, counter.get(carName) + 1);
            } else {
                counter.put(carName, 1);
            }
        }

        counter.keySet().stream()
            .filter(carName -> counter.get(carName) > 1)
            .forEach(carName -> makeCountingName(carNames, carName));
    }

    private static void makeCountingName(List<String> carNames, String carName) {
        int count = 1;
        for (int i = 0; i < carNames.size(); i++) {
            if (carName.equals(carNames.get(i))) {
                carNames.set(i, String.format(DUPLICATED_NAME, carName, count));
                count++;
            }
        }
    }
}
