package racingcar;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Count {
    private static final int MAXIMUM_COUNT = 30;
    private static final int MINIMUM_COUNT = 1;

    private int racingCount = 0;

    public int validate(String input) {
        validateNumber(input);
        validateRange();
        return racingCount;
    }

    private void validateNumber(String input) {
        try {
            racingCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 허용하는 숫자가 아닙니다.");
        }
    }

    private void validateRange() {
        validateMinimal();
        validateMaximal();
    }

    private void validateMinimal() {
        if (racingCount < MINIMUM_COUNT ) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    private void validateMaximal() {
        if (racingCount > MAXIMUM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 30회 이하여야 합니다.");
        }
    }
}
