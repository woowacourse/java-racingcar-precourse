package utils;

import racingcar.Car;
import racingcar.type.ErrorType;
import racingcar.type.TextType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputUtils {

    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int ZERO = 0;

    public static Car validateCar(String carName) {
        // 자동차 이름의 길이가 1자 미만 또는 5자 초과인 경우
        if (carName.length() < MINIMUM_CAR_NAME_LENGTH || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorType.INVALID_LENGTH.getError());
        }

        // 자동차 이름에 공백이 있는 경우
        if (carName.contains(TextType.BLANK_TEXT.getText())) {
            throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getError());
        }

        return new Car(carName);
    }

    public static void checkDuplicatedCar(ArrayList<Car> cars) {
        Set<String> carSet = new HashSet<>();

        for (Car car : cars) {
            carSet.add(car.getName());
        }

        // 자동차 이름이 중복되는 경우
        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_DUPLICATION.getError());
        }
    }

    public static void validateTimes(int scannerTimes) {
        // 시도할 횟수에 음수 또는 0이 입력되는 경우
        if (scannerTimes <= ZERO) {
            throw new IllegalArgumentException(ErrorType.INVALID_ZERO_TIME.getError());
        }
    }
}
