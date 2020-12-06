package racingcar.validators;

import racingcar.exceptions.NotNumericTrialCountException;
import racingcar.exceptions.NotPositiveTrialCountException;

public class TrialCountValidator {
    private static final int ZERO = 0;

    private TrialCountValidator() {
    }

    public static void validateTrialCount(String trialCount) {
        validateNumeric(trialCount);
        validatePositive(trialCount);
    }

    private static void validateNumeric(String trialCount) {
        if (!isNumeric(trialCount)) {
            throw new NotNumericTrialCountException();
        }
    }

    private static boolean isNumeric(String trialCount) {
        try {
            Integer.parseInt(trialCount);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static void validatePositive(String trailCount) {
        if (!isPositive(trailCount)) {
            throw new NotPositiveTrialCountException();
        }
    }

    private static boolean isPositive(String trialCount) {
        return Integer.parseInt(trialCount) > ZERO;
    }
}
