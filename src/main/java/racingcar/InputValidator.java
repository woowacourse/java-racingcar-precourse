package racingcar;

public class InputValidator {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 5자 이하만의 이름을 입력해주세요.";
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final int MAX_LENGTH_CAR_NAME = 5;

    protected static final boolean validateCarName(String[] carNameArray) {
        try {
            if (!validateNameSize(carNameArray)) {
                throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
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
        for (String carNameArrayIndex : carNameArray) {
            if (carNameArrayIndex.length() > MAX_LENGTH_CAR_NAME) {
                return false;
            }
        }
        return true;
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
