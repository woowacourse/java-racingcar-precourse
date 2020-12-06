package utils;

import racingcar.domain.Car;
import racingcar.type.BoundaryType;
import racingcar.type.ErrorType;
import racingcar.type.TextType;
import racingcar.type.ValueType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 비정상적인 입력에 대해서는 예외를 발생시키는 클래스
 *
 * @author Daeun Lee
 */
public class InputUtils {
    /**
     * @param carName 자동차 이름
     * @return 자동차
     */
    public static Car validateCar(String carName) {
        // 자동차 이름의 길이가 1자 미만 또는 5자 초과인 경우
        if ((carName.length() < BoundaryType.MINIMUM_CAR_NAME_LENGTH.getBoundary())
                || (carName.length() > BoundaryType.MAXIMUM_CAR_NAME_LENGTH.getBoundary())) {
            throw new IllegalArgumentException(ErrorType.INVALID_LENGTH.getError());
        }

        // 자동차 이름에 공백이 있는 경우
        if (carName.contains(TextType.BLANK_TEXT.getText())) {
            throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getError());
        }

        return new Car(carName);
    }

    /**
     * @param cars 자동차를 원소로 가진 리스트
     */
    public static void validateDuplicateCar(ArrayList<Car> cars) {
        Set<String> carSet = new HashSet<>();

        for (Car car : cars) {
            carSet.add(car.getName());
        }

        // 자동차 이름이 중복되는 경우
        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_DUPLICATION.getError());
        }
    }

    /**
     * @param scannerTimes 사용자가 입력한 자동차 경주 게임을 시도할 횟수
     */
    public static void validateTimes(int scannerTimes) {
        // 시도할 횟수에 음수 또는 0이 입력되는 경우
        if (scannerTimes <= ValueType.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorType.INVALID_ZERO_TIME.getError());
        }
    }
}
