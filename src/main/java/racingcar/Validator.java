package racingcar;

public class Validator {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int REPEAT_TIME_MINIMUM = 1;

    public void validateCarName(String carName) {
        if (isCarNameLengthOverFive(carName)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 이름의 길이가 5를 넘습니다");
        }
    }

    public Integer validateRepeatTimes(String rawRepeatTimes) {
        Integer repeatTimes = convertToNumber(rawRepeatTimes);
        checkRepeatTimesOverOne(repeatTimes);
        return repeatTimes;
    }

    private boolean isCarNameLengthOverFive(String carName) {
        return carName.length() > CAR_NAME_LENGTH_LIMIT;
    }

    private Integer convertToNumber(String rawRepeatTimes) {
        try {
            return Integer.parseInt(rawRepeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자를 입력해야 합니다.");
        }
    }

    private void checkRepeatTimesOverOne(Integer repeatTimes) {
        if (repeatTimes < REPEAT_TIME_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1 이상의 수를 입력해야 합니다");
        }
    }
}
