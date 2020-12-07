package utils.validator;

/**
 * 이 클래스는 자동차 이동 횟수 입력을 검증하는 클래스입니다.
 * - 입력된 값이 숫자(정수)인지 검증합니다.
 * - 입력된 값이 양수인지 검증합니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class MoveInputValidator {

    private static final String NUMBER_FORMAT_ERROR_MSG = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String NEGETIVE_NUMBER_ERROR_MSG = "[ERROR] 시도 횟수는 양수여야 합니다.";

    private MoveInputValidator() {}

    public static int validateNumOfMove(String input) {
        try {
            int numOfMove = Integer.parseInt(input);
            validatePositiveNumber(numOfMove);
            return numOfMove;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_ERROR_MSG);
        }
    }

    private static void validatePositiveNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException(NEGETIVE_NUMBER_ERROR_MSG);
        }
    }
}
