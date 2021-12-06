package racingcar;

public class AttemptCountValidator {
    private static final String COUNTS_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 자연수여야 한다.";
    private static final String ATTEMPT_COUNTS_VALIDATE_REGEX = "^[1-9][0-9]*$";

    public static void checkException(String counts) {
        if (!checkNaturalNumber(counts)) {
            throw new IllegalArgumentException(COUNTS_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static boolean checkNaturalNumber(String counts) {
        return counts.matches(ATTEMPT_COUNTS_VALIDATE_REGEX);
    }
}
