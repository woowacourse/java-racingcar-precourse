package racingcar.game;

public class UserTryTimeInputErrorHandler {
    public static final String NOT_NUMBER_ERROR_MESSAGE
        = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    public static final String INVALID_RANGE_NUMBER_ERROR_MESSAGE
        = "[ERROR] 시도 횟수는 1회 이상 1000회 이하여야 합니다.";

    public void printNotNumberErrorMessage() {
        System.out.println(NOT_NUMBER_ERROR_MESSAGE);
    }

    public void printInvalidRangeNumberErrorMessage() {
        System.out.println(INVALID_RANGE_NUMBER_ERROR_MESSAGE);
    }
}
