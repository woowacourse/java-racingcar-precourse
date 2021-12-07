package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarList;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.StringTokenizer;

public class RacingGame {
    private static final String DELIM = ",";

    private CarList carList;
    private int rounds;

    public void run() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        processCarNames();
        inputRounds();
    }

    private void playGame() {
        OutputView.printExecutionMessage();

        for (int i = 0; i < rounds; i++) {
            carList.moveAllCars();
            OutputView.printResult(carList.getCarList());
        }
    }

    private void endGame() {
        OutputView.printWinner(carList.findWinner());
    }

    private void processCarNames() {
        InputView.printInputCarNamesMessage();

        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(inputCarNames(), DELIM);
                carList = new CarList(Validator.validateCarName(st));
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
                Validator.clearHashSet();
            }
        }
    }

    private String inputCarNames() {
        while (true) {
            try {
                String input = Console.readLine();
                Validator.validateNamesInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void inputRounds() {
        InputView.printInputRoundsMessage();

        while (true) {
            try {
                rounds = Validator.validateNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
