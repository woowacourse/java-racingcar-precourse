package racingcar;

import static racingcar.utils.StringUtils.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.gameresult.GameResult;
import racingcar.inputvalue.CarNamesInputValue;
import racingcar.inputvalue.InputValue;
import racingcar.inputvalue.NumberOfRoundsInputValue;
import racingcar.view.GameResultView;
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
        printGameResult(startGame());
        printWinners(findWinners());
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
                printErrorMessage(e.getMessage());
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
                printErrorMessage(ERROR_MESSAGE_ABOUT_WRONG_NUMBER_OF_ROUNDS_INPUT);
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

    private GameResult startGame() {
        return racingGameService.start();
    }

    private void printGameResult(GameResult gameResult) {
        new GameResultView(gameResult).print();
    }

    private List<Car> findWinners() {
        return racingGameService.determineWinners();
    }

    private void printWinners(List<Car> winners) {
        new RacingWinnersView(winners).print();
    }

    private void printErrorMessage(String errorMessage) {
        System.out.print(PREFIX_OF_ERROR_MESSAGE);
        System.out.println(errorMessage);
    }
}
