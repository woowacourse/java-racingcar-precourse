package racingcar.domain;

import racingcar.view.OutputView;

public class AttemptNumber {
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final String ATTEMPT_NUMBER_RANGE_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다";

    private final int attemptNumber;

    public AttemptNumber(int attemptNumber) {
        validateRangeAttemptNumber(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    private void validateRangeAttemptNumber(int attemptNumber) {
        if (attemptNumber < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR);
        }
    }

    public void moveOrStopByAttemptNumber(Cars cars) {
        OutputView.printResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            cars.moveOrStop();
            cars.printResultState();
        }
    }
}
