package racingcar.game;

import view.OutputView;

public class GameRound {

    public static final int MINIMAL_COUNT = 1;

    private final int count;

    public GameRound(String rawCount) {
        validate(rawCount);
        count = Integer.parseInt(rawCount);
    }

    private void validate(String rawCount) {
        validateNumeric(rawCount);
        validateAtLeastMinimalCount(rawCount);
    }

    private void validateAtLeastMinimalCount(String rawCount) {
        if (isLessThanMinimalCount(rawCount)) {
            throw new IllegalArgumentException(OutputView.IS_SMALLER_THAN_MINIMAL_ERROR);
        }
    }

    private boolean isLessThanMinimalCount(String rawCount) {
        return Integer.parseInt(rawCount) < MINIMAL_COUNT;
    }

    private void validateNumeric(String rawCount) {
        try {
            Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.NOT_NUMBER_ERROR);
        }
    }

    public int getCount() {
        return count;
    }
}
