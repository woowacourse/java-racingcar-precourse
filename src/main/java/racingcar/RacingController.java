package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputvalue.CarNameInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.RoundNumberInputValue;

public class RacingController {
    private final RacingGame racingGame;

    public RacingController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public String[] createCars() {
        InputValue<String[]> carNameInput = new CarNameInputValue(Console.readLine());
        String[] carNameStrings = carNameInput.toRaceElement();
        racingGame.createCars(carNameStrings);
        return carNameStrings;
    }

    public int inputRoundNumber() {
        InputValue<Integer> roundNumberInput = new RoundNumberInputValue(Console.readLine());
        return roundNumberInput.toRaceElement();
    }
}
