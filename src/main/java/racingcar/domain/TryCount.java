package racingcar.domain;

import static racingcar.message.ErrorMessage.TRY_COUNT_MUST_BE_NUMBER;

public class TryCount {
    private final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public TryCount(String tryCount) {
        validateNumber(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_NUMBER.getMessage());
        }
    }

    public int getCount() {
        return tryCount;
    }
}
