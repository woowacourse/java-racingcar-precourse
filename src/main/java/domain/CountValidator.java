package domain;

/**
 * 입력받은 횟수의 유효성을 판단하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class CountValidator {
    private static final int MINIMUM_OF_COUNT = 0;

    public static int makeValidCount(String inputData) {
        checkNumber(inputData);
        checkMoreThanZero(inputData);
        return Integer.parseInt(inputData);
    }

    private static boolean isNotNumber(String inputData) {
        try {
            Integer.parseInt(inputData);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static void checkNumber(String inputData) {
        if (isNotNumber(inputData)) {
            throw new IllegalArgumentException("횟수 입력은 숫자여야 한다.");
        }
    }

    private static void checkMoreThanZero(String inputData) {
        if (Integer.parseInt(inputData) < MINIMUM_OF_COUNT) {
            throw new IllegalArgumentException("횟수 입력은 0 이상이어야 한다.");
        }
    }
}
