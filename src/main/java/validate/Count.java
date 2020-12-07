package validate;

import static game.Rule.MAXIMUM_RACING_COUNT;
import static game.Rule.MINIMUM_RACING_COUNT;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Count extends Error {
    public static final String NOT_ALLOW_NUMBER = "허용하는 숫자가 아닙니다.";
    public static final String UNDER_TRY_COUNT =
            "시도 횟수는 " + MINIMUM_RACING_COUNT + "회 이상이어야 합니다.";
    public static final String OVER_TRY_COUNT =
            "시도 횟수는 "+ MAXIMUM_RACING_COUNT + "회 이하여야 합니다.";

    private int racingCount = 0;

    public int validate(final String input) {
        validateNumber(input);
        validateRange();
        return racingCount;
    }

    private void validateNumber(final String input) {
        try {
            racingCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throwMessage(NOT_ALLOW_NUMBER);
        }
    }

    private void validateRange() {
        validateMinimum();
        validateMaximum();
    }

    private void validateMinimum() {
        if (racingCount < MINIMUM_RACING_COUNT) {
            throwMessage(UNDER_TRY_COUNT);
        }
    }

    private void validateMaximum() {
        if (racingCount > MAXIMUM_RACING_COUNT) {
            throwMessage(OVER_TRY_COUNT);
        }
    }
}
