package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputvalue.CarNameInputValue;
import racingcar.inputvalue.InputValue;

public class RacingController {

    public String[] inputCarNames() {
        InputValue<String[]> carNameInput = new CarNameInputValue(Console.readLine());
        return carNameInput.toRaceElement();
    }
}
