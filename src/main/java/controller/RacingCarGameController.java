package controller;

import domain.Count;
import domain.NamesValidator;
import domain.racingcar.Cars;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 전체 게임을 진행하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 8일
 */
public class RacingCarGameController {
    private final InputView inputView;

    public RacingCarGameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = new Cars(makeNames());
        Count count = generateCount();

        OutputView.printResult();
        while (count.isBiggerThanZeroWhenDecreaseOne()) {
            cars.playUnitGame();
            OutputView.printNowCars(cars.makeUnitResult());
            OutputView.printOneLine();
        }

        OutputView.printWinner(cars.generateWinners());
    }

    private List<String> makeNames() {
        try {
            return NamesValidator.makeNames(this.inputView.receiveNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeNames();
        }
    }

    private Count generateCount() {
        try {
            return new Count(this.inputView.receiveCounts());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateCount();
        }
    }
}
