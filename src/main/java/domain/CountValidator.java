package domain;

/**
 * 입력받은 횟수의 유효성을 판단하여 유효한 값을 돌려주는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 7일
 */
public class CountValidator {
    private static final int MINIMUM_OF_COUNT = 0;

    public static int makeValidCount(final String inputCount) {
        checkNumber(inputCount);
        checkMoreThanZero(inputCount);
        return Integer.parseInt(inputCount);
    }

    private static boolean isNotNumber(final String inputCount) {
        try {
            Integer.parseInt(inputCount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static void checkNumber(final String inputCount) {
        if (isNotNumber(inputCount)) {
            throw new IllegalArgumentException("횟수 입력은 숫자여야 한다.");
        }
    }

    private static void checkMoreThanZero(final String inputCount) {
        if (Integer.parseInt(inputCount) < MINIMUM_OF_COUNT) {
            throw new IllegalArgumentException("횟수 입력은 0 이상이어야 한다.");
        }
    }
}
