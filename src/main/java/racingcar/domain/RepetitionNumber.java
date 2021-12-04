package racingcar.domain;

import racingcar.domain.exception.RepetitionNumberValidator;
import racingcar.domain.exception.Validator;

public class RepetitionNumber {
    private final int repetitionNumber;

    public RepetitionNumber(String repetitionNumber) {
        RepetitionNumberValidator validator = new Validator();
        validator.isValid(repetitionNumber);
        this.repetitionNumber = validator.convertStringToInt(repetitionNumber);
    }

    public int getRepetitionNumber() {
        return repetitionNumber;
    }
}
