package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarsNameDTO;
import racingcar.dto.NumberOfTryDTO;
import racingcar.validator.InputCarsNameValidator;
import racingcar.validator.InputNumberOfTryValidator;

public class InputView {
    
    public CarsNameDTO inputCarsName(final OutputView outputView) {
        outputView.printCarNameInputGuideMessage();
        try {
            final String carsName = userInput();
            InputCarsNameValidator.validate(carsName);
            return new CarsNameDTO(carsName);
        } catch (IllegalArgumentException raisedException) {
            outputView.printErrorMessage(raisedException);
            return inputCarsName(outputView);
        }
    }
    
    public NumberOfTryDTO inputNumberOfTry(final OutputView outputView) {
        outputView.printNumberOfTryInputGuideMessage();
        try {
            final String numberOfTry = userInput();
            InputNumberOfTryValidator.validate(numberOfTry);
            return new NumberOfTryDTO(numberOfTry);
        } catch (IllegalArgumentException raisedException) {
            outputView.printErrorMessage(raisedException);
            return inputNumberOfTry(outputView);
        }
    }
    
    private String userInput() {
        return Console.readLine();
    }
}
