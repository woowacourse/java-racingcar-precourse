package racingcar;

public class Validator {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final int REPEAT_TIME_MINIMUM = 0;

    public void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 이름의 길이가 5를 넘습니다");
        }
    }

    public Integer convertToNumber(String rawRepeatTimes) {
        try {
            return Integer.parseInt(rawRepeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자를 입력해야 합니다.");
        }
    }

    public void validateRepeatTimes(Integer repeatTimes) {
        if (repeatTimes <= REPEAT_TIME_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1 이상의 수를 입력해야 합니다");
        }
    }
}
