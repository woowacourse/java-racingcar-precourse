package racingcar.validator;

import java.util.List;

public class Validator {
    private final String NEED_MORE_THAN_ONE_CAR = "자동차가 1대 이상일 때 경주가 가능합니다.";
    private final String CAR_NAME_MUST_BE_LESS_THAN_5_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private final String TRIAL_COUNT_MUST_BE_NUMBER_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    private final String TRIAL_COUNT_MUST_BE_SAME_OR_BIGGER_THAN_0_MESSAGE = "시도 횟수는 0이상만 가능합니다.";

    public void validateCarNames(List<String> carNames) {
        if (carNames.size() <= 0) {
            throw new IllegalArgumentException(NEED_MORE_THAN_ONE_CAR);
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_MUST_BE_LESS_THAN_5_MESSAGE);
            }
        }
    }

    public void validateTrialCount(String stringTrialCount) {
        int trialCount;
        try {
            trialCount = Integer.parseInt(stringTrialCount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(TRIAL_COUNT_MUST_BE_NUMBER_MESSAGE);
        }

        if (trialCount < 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_MUST_BE_SAME_OR_BIGGER_THAN_0_MESSAGE);
        }
    }
}
