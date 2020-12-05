package utils.validator;

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
