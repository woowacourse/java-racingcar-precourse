package racingcar;

import static racingcar.Rule.MAXIMUM_COUNT;
import static racingcar.Rule.MINIMUM_COUNT;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Count extends Error {
    public static final String NOT_ALLOW_NUMBER = "허용하는 숫자가 아닙니다.";
    public static final String UNDER_TRY_COUNT =
            "시도 횟수는 " + MINIMUM_COUNT + "회 이상이어야 합니다.";
    public static final String OVER_TRY_COUNT =
            "시도 횟수는 "+ MAXIMUM_COUNT + "회 이하여야 합니다.";

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
            throwMessage(NOT_ALLOW_NUMBER);
        }
    }

    private void validateRange() {
        validateMinimal();
        validateMaximal();
    }

    private void validateMinimal() {
        if (racingCount < MINIMUM_COUNT) {
            throwMessage(UNDER_TRY_COUNT);
        }
    }

    private void validateMaximal() {
        if (racingCount > MAXIMUM_COUNT) {
            throwMessage(OVER_TRY_COUNT);
        }
    }
}
