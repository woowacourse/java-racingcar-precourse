package racingcar.domain.trycount;

import static racingcar.domain.error.ErrorMessage.*;

public class TryCount {
    private static final int ZERO_NUMBER = 0;

    private int tryCount;

    public TryCount(String inputTryCount) {
        validateNumberFormat(inputTryCount);
        int tryCount = Integer.parseInt(inputTryCount);
        validateNegativeNumber(tryCount);
        this.tryCount = tryCount;
    }

    private void validateNumberFormat(String inputTryCount) {
        try {
            Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_NOT_VALID.getMessage());
        }
    }

    private void validateNegativeNumber(int parseTryCount) {
        if (parseTryCount < ZERO_NUMBER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_VALID.getMessage());
        }
    }

    public boolean hasNextCount() {
        if (tryCount != ZERO_NUMBER) {
            tryCount--;
            return true;
        }
        return false;
    }
}