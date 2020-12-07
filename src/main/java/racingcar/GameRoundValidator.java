package racingcar;

public class GameRoundValidator {
    private static final String ONLY_NUMBER_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.\n";
    private static final String NO_ZERO_MESSAGE = "[ERROR] 시도 횟수는 0보다 커야 한다.\n";
    private static final String NUMBER_REGEX = "\\d{1,}";
    private static final String ZERO = "0";

    public static void validateGameRound(String round) {
        checkGameRoundIsNumber(round);
        checkGameRoundIsNotZero(round);
    }

    private static void checkGameRoundIsNumber(String round) {
        if (!isNumber(round)) {
            throw new IllegalGameRoundException(ONLY_NUMBER_MESSAGE);
        }
    }

    private static boolean isNumber(String round) {
        return round.matches(NUMBER_REGEX);
    }

    private static void checkGameRoundIsNotZero(String round) {
        if (isZero(round)) {
            throw new IllegalGameRoundException(NO_ZERO_MESSAGE);
        }
    }

    private static boolean isZero(String round) {
        return round.equals(ZERO);
    }
}
