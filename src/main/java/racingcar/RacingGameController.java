package racingcar;

import static racingcar.utils.StringUtils.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.inputvalue.CarNamesInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.NumberOfRoundsInputValue;
import racingcar.gameresult.RacingGameResult;
import racingcar.view.RacingGameResultView;
import racingcar.view.RacingWinnersView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void start() {
        printCarNameRequestMessage();
        setCars();
        printNumberOfRoundsRequestMessage();
        setRacingGame();
        printGameResult();
        printWinners();
    }

    private void printCarNameRequestMessage() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
    }

    private void setCars() {
        boolean isAllCarsCreated = false;
        while(!isAllCarsCreated) {
            try {
                setCars(inputCarNames());
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

    private void setCars(String[] carNames) {
        racingGameService.getCarsReady(carNames);
    }

    private void printNumberOfRoundsRequestMessage() {
        System.out.println(NUMBER_OF_ROUNDS_REQUEST_MESSAGE);
    }

    private void setRacingGame() {
        boolean isNumberOfRoundsCreated = false;
        while(!isNumberOfRoundsCreated) {
            try {
                setRacingGame(inputNumberOfRounds());
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

    private void setRacingGame(int numberOfRounds) {
        racingGameService.getRacingGameReady(numberOfRounds);
    }

    private void printGameResult() {
        printGameResult(racingGameService.start());
    }

    private void printGameResult(RacingGameResult racingGameResult) {
        new RacingGameResultView(racingGameResult).print();
    }

    private void printWinners() {
        printWinners(racingGameService.determineWinners());
    }

    private void printWinners(List<Car> winners) {
        RacingWinnersView racingWinnersView = new RacingWinnersView(winners);
        racingWinnersView.print();
    }
}
