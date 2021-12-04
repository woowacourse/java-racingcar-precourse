package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.inputvalue.CarNameInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.NumberOfRoundsInputValue;

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

    public int createNumberOfRounds() {
        InputValue<Integer> NumberOfRoundsInput = new NumberOfRoundsInputValue(Console.readLine());
        int numberOfRounds = NumberOfRoundsInput.toRaceElement();
        racingGame.createNumberOfRounds(numberOfRounds);
        return numberOfRounds;
    }
}
