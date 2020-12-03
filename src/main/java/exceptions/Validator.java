package exceptions;

import exceptions.customExceptions.NotValidInputException;
import racingcar.Car;

import java.util.List;

public class Validator {

    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 입력되어야 합니다.";
    private static final int MINIMUM_CARS_SIZE = 1;

    public static void validateCarsSize(List<Car> cars) {

        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new NotValidInputException(EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
    }

}
