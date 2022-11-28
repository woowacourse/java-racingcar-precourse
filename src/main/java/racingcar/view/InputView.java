package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarsNameDTO;
import racingcar.dto.NumberOfTryDTO;
import racingcar.validator.InputCarsNameValidator;
import racingcar.validator.InputNumberOfTryValidator;

public class InputView {
    
    public CarsNameDTO inputCarsName() {
        final String carsName = userInput();
        InputCarsNameValidator.validate(carsName);
        return new CarsNameDTO(carsName);
    }
    
    public NumberOfTryDTO inputNumberOfTry() {
        final String numberOfTry = userInput();
        InputNumberOfTryValidator.validate(numberOfTry);
        return new NumberOfTryDTO(numberOfTry);
    }
    
    private String userInput() {
        return Console.readLine();
    }
}
