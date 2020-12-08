package domain;

public class TotalRound {
    private static final String EMPTY_EXCEPTION = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String NOT_NUMBER_EXCEPTION = "[ERROR] 숫자를 입력해야 합니다.";
    private static final String IMPOSSIBLE_NUMBER_ZERO_EXCEPTION = "[ERROR] 0은 임력할 수 없습니다.";
    private static final String EMPTY_INPUT = "";
    private static final String ZERO = "0";

    private int totalRound;

    public TotalRound(String totalRound) {
        isEmptyInput(totalRound);
        isNumber(totalRound);
        isZero(totalRound);
        this.totalRound = Integer.parseInt(totalRound);
    }

    private static void isEmptyInput(String input) {
        if (input.equals(EMPTY_INPUT)) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
    }

    private static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void isZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(IMPOSSIBLE_NUMBER_ZERO_EXCEPTION);
        }
    }

    public int getTotalRound() {
        return totalRound;
    }
}
