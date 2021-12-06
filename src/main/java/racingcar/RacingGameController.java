package racingcar;

import static racingcar.utils.StringUtils.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.inputvalue.CarNamesInputValue;
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
        createCars();
        printNumberOfRoundsRequestMessage();
        createNumberOfRounds();
        printGameResultNoticePhrase();
        printWinners(racingGame.start());
    }

    private void printCarNameRequestMessage() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    private void createCars() {
        boolean isAllCarsCreated = false;
        while(!isAllCarsCreated) {
            try {
                createCars(inputCarNames());
                isAllCarsCreated = true;
            } catch(IllegalArgumentException e) {
                System.out.print(PREFIX_OF_ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] inputCarNames() {
        InputValue<String[]> carNamesInput = new CarNamesInputValue(Console.readLine());
        return carNamesInput.toRacingElement();
    }

    private void createCars(String[] carNames) {
        racingGame.getCarsReady(carNames);
    }

    private void printNumberOfRoundsRequestMessage() {
        System.out.println(NUMBER_OF_ROUNDS_REQUEST_MESSAGE);
    }

    private void createNumberOfRounds() {
        boolean isNumberOfRoundsCreated = false;
        while(!isNumberOfRoundsCreated) {
            try {
                createNumberOfRounds(inputNumberOfRounds());
                isNumberOfRoundsCreated = true;
            } catch (IllegalArgumentException e) {
                System.out.print(PREFIX_OF_ERROR_MESSAGE);
                System.out.println(ERROR_MESSAGE_ABOUT_WRONG_NUMBER_OF_ROUNDS_INPUT);
            }
        }
    }

    private int inputNumberOfRounds() {
        InputValue<Integer> NumberOfRoundsInput = new NumberOfRoundsInputValue(Console.readLine());
        return NumberOfRoundsInput.toRacingElement();
    }

    private void createNumberOfRounds(int numberOfRounds) {
        racingGame.setNumberOfRounds(numberOfRounds);
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
