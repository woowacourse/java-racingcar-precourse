package validation;

import view.OutputView;

public class TryNumberValidator {
    private TryNumberValidator() {
    }

    public static void validateTryNumber(int tryNumber) throws IllegalArgumentException {
        if (tryNumber < 1) {
            throw new IllegalArgumentException(OutputView.getNegativeErrorMessage());
        }
    }
}
