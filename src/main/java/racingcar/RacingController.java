package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputvalue.CarNameInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.RoundNumberInputValue;

public class RacingController {

    public String[] inputCarNames() {
        InputValue<String[]> carNameInput = new CarNameInputValue(Console.readLine());
        return carNameInput.toRaceElement();
    }

    public int inputRoundNumber() {
        InputValue<Integer> roundNumberInput = new RoundNumberInputValue(Console.readLine());
        return roundNumberInput.toRaceElement();
    }
}
