package racingcar.service;

import racingcar.validator.InputCarNameValidator;
import racingcar.validator.InputTryNumberValidator;

public class RacingCarGameValidateService {

    private final InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();
    private final InputTryNumberValidator inputTryNumberValidator = new InputTryNumberValidator();

    public void validateInputCarName(String inputCarName) {
        inputCarNameValidator.validate(inputCarName);
    }

    public void validateInputTryNumber(String inputTryNumber) {
        inputTryNumberValidator.validate(inputTryNumber);
    }
}
