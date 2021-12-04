package racingcar.domain.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator implements CarNameValidator, RepetitionNumberValidator {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_SIZE = 2;
    private static final int REPETITION_MIN_RANGE = 1;
    private static final String CAR_NAME_MIN_LENGTH_ERROR_MESSAGE = " 자동차 이름은 공백일 수 없습니다.";
    private static final String CAR_NAME_MAX_LENGTH_ERROR_MESSAGE = " 자동차 이름은 5글자 이하여야합니다. ";
    private static final String CARS_SIZE_ERROR_MESSAGE = " 경주에 참여할 자동차는 2대 이상이어야합니다. ";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = " 중복된 자동차 이름이 있습니다.";
    private static final String REPETITION_NUMBER_INPUT_RANGE_ERROR_MESSAGE = " 최소 1이상의 값이 입력되어야합니다.";
    private static final String REPETITION_NUMBER_INPUT_TYPE_ERROR_MESSAGE = " 시도 횟수는 숫자여야 한다.";

    @Override
    public boolean isAllValid(String[] cars) {
        if (!isCars(cars)) {
            throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH_ERROR_MESSAGE);
        }
        if (isDuplication(cars)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
        isNameValid(cars);
        return true;
    }

    @Override
    public boolean isNameValid(String[] cars) {
        for (String carName : cars) {
            if (isBlank(carName)) {
                throw new IllegalArgumentException(CAR_NAME_MIN_LENGTH_ERROR_MESSAGE);
            }
            if (!validateNameRange(carName)) {
                throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH_ERROR_MESSAGE);
            }
        }
        return true;
    }

    @Override
    public boolean isBlank(String name) {
        if (name.trim().isEmpty()) {
            printMessage(CAR_NAME_MIN_LENGTH_ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    @Override
    public boolean isCars(String[] names) {
        if (names.length < MIN_SIZE) {
            printMessage(CARS_SIZE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public boolean isDuplication(String[] names) {
        Set<String> carNames = new HashSet<>(Arrays.asList(names));
        if (carNames.size() != names.length) {
            printMessage(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    @Override
    public boolean validateNameRange(String name) {
        if (name.length() > MAX_LENGTH) {
            printMessage(CAR_NAME_MAX_LENGTH_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    @Override
    public boolean isValid(String targetNumber) {
        int number = 0;
        try {
            number = convertStringToInt(targetNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REPETITION_NUMBER_INPUT_TYPE_ERROR_MESSAGE);
        }
        if (!validateRange(number)) {
            throw new IllegalArgumentException(REPETITION_NUMBER_INPUT_RANGE_ERROR_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean validateRange(int number) {
        if (number < REPETITION_MIN_RANGE) {
            printMessage(REPETITION_NUMBER_INPUT_RANGE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public void printMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }
}
