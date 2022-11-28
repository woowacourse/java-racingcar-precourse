package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarsNameDTO;
import racingcar.validator.InputCarsNameValidator;

public class InputView {
    
    public CarsNameDTO inputCarsName() {
        final String carsName = Console.readLine();
        InputCarsNameValidator.validate(carsName);
        return new CarsNameDTO(carsName);
    }
}
