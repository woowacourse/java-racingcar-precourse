package racingcar;

import static racingcar.utils.StringConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.inputvalue.CarNameInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.NumberOfRoundsInputValue;
import racingcar.view.RacingWinnersView;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void start() {
        printCarNameRequestMessage();
        createCars(inputCarNames());
        printNumberOfRoundsRequestMessage();
        createNumberOfRounds(inputNumberOfRounds());
        printGameResultNoticePhrase();
        printWinners(racingGame.start());
    }

    private void printCarNameRequestMessage() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    private String[] inputCarNames() {
        InputValue<String[]> carNameInput = new CarNameInputValue(Console.readLine());
        return carNameInput.toRaceElement();
    }

    private void createCars(String[] carNames) {
        racingGame.createCars(carNames);
    }

    private void printNumberOfRoundsRequestMessage() {
        System.out.println(NUMBER_OF_ROUNDS_REQUEST_MESSAGE);
    }

    private int inputNumberOfRounds() {
        InputValue<Integer> NumberOfRoundsInput = new NumberOfRoundsInputValue(Console.readLine());
        return NumberOfRoundsInput.toRaceElement();
    }

    private void createNumberOfRounds(int numberOfRounds) {
        racingGame.createNumberOfRounds(numberOfRounds);
    }

    private void printGameResultNoticePhrase() {
        System.out.println();
        System.out.println(GAME_RESULT_NOTICE_PHRASE);
    }

    private void printWinners(List<Car> winners) {
        RacingWinnersView racingWinnersView = new RacingWinnersView(winners);
        racingWinnersView.print();
    }
}
