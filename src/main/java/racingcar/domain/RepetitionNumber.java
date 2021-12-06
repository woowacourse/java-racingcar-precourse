package racingcar.domain;

import racingcar.domain.exception.RepetitionNumberValidator;

public class RepetitionNumber {
    private final int repetitionNumber;

    public RepetitionNumber(String repetitionNumber, RepetitionNumberValidator numberValidator) {
        numberValidator.isValid(repetitionNumber);
        this.repetitionNumber = numberValidator.convertStringToInt(repetitionNumber);
    }

    public boolean isSameNumber(int targetNum) {
        return targetNum == repetitionNumber;
    }
}
