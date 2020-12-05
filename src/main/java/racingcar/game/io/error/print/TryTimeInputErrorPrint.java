package racingcar.game.io.error.print;

public class TryTimeInputErrorPrint {
    private static final String NOT_NUMBER_ERROR_MESSAGE
        = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    private static final String INVALID_RANGE_NUMBER_ERROR_MESSAGE
        = "[ERROR] 시도 횟수는 1회 이상 10회 이하여야 합니다.";

    public static void printNotNumberErrorMessage() {
        System.out.println(NOT_NUMBER_ERROR_MESSAGE);
    }

    public static void printInvalidRangeNumberErrorMessage() {
        System.out.println(INVALID_RANGE_NUMBER_ERROR_MESSAGE);
    }
}
