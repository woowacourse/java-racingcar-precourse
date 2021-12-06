package racingcar;

import java.util.Arrays;

public class InputValidator {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 5자 이하만의 이름을 입력해주세요.";
    private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "[ERROR] 공백을 제외한 이름을 입력해주세요.";
    private static final String DUPLICATE_NAME_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않는 서로 다른 이름을 입력해주세요.";
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String MIN_CAR_COUNT_MESSAGE = "[ERROR] 차동차는 최소 2대 이상이어야 한다.";
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_LENGTH_CAR_NAME = 5;
    private static final int MIN_LENGTH_CAR_NAME = 0;

    protected static final boolean validateCarName(String[] carNameArray) {
        try {
            if (validateNameSize(carNameArray)) {
                throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
            } else if (validateEmptyName(carNameArray)) {
                throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE);
            } else if (validateDuplicateName(carNameArray)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_EXCEPTION_MESSAGE);
            } else if (validateCarCountRule(carNameArray)) {
                throw new IllegalArgumentException(MIN_CAR_COUNT_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    protected static final boolean validateNumberOfAttempts(String numberOfAttempts) {
        try {
            if (!validateNumber(numberOfAttempts)) {
                throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static final boolean validateNameSize(String[] carNameArray) {
        return Arrays.stream(carNameArray)
                .anyMatch(carName -> carName.length() > MAX_LENGTH_CAR_NAME);
    }

    private static final boolean validateEmptyName(String[] carNameArray) {
        return !Arrays.stream(carNameArray)
                .allMatch(carName -> carName.length() > MIN_LENGTH_CAR_NAME);
    }

    private static final boolean validateDuplicateName(String[] carNameArray) {
        return carNameArray.length != Arrays.stream(carNameArray)
                .distinct()
                .count();
    }

    private static final boolean validateCarCountRule(String[] carNameArray) {
        return carNameArray.length < MIN_CAR_COUNT;
    }

    private static final boolean validateNumber(String numberOfAttempts) {
        char tempNum;

        for (int i = 0; i < numberOfAttempts.length(); i++) {
            tempNum = numberOfAttempts.charAt(i);
            if (!Character.isDigit(tempNum)) {
                return false;
            }
        }
        return true;
    }

}
