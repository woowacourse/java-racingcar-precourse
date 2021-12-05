package racingcar;

import static racingcar.StringConstants.DELIMITER_BETWEEN_WINNERS;
import static racingcar.StringConstants.PREFIX_OF_WINNER_NOTICE;

import java.util.List;
import java.util.stream.Collectors;

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

    public void showWinners() {
        List<Car> winners = racingGame.determineWinners();
        RacingWinnersView racingWinnersView = new RacingWinnersView(winners);
        racingWinnersView.print();
    }
}
