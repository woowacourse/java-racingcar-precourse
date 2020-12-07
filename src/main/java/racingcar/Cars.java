package racingcar;

import static racingcar.Messages.NAMES_CAN_NOT_DUPLICATE;

import exceptions.InvalidInputException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private Cars() {
    }

    public static List<Car> getCars(String input) throws InvalidInputException {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        validateDuplicateName(cars);

        return cars;
    }

    private static void validateDuplicateName(List<Car> cars) {
        HashSet<Car> carSet = new HashSet<>(cars);

        if (carSet.size() != cars.size()) {
            throw new InvalidInputException(NAMES_CAN_NOT_DUPLICATE);
        }
    }
}
