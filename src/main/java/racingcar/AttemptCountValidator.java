package racingcar;

public class AttemptCountValidator {
    static final String COUNTS_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 자연수여야 한다.";

    public static void checkException(String counts) {
        if (!checkNaturalNumber(counts)) {
            throw new IllegalArgumentException(COUNTS_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static boolean checkNaturalNumber(String counts) {
        return counts.matches("^[0-9]+$");
    }
}
