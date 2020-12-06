package controller;

import domain.CountValidator;
import domain.NamesValidator;
import domain.racingcar.CarFactory;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 전체 게임을 진행하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 3일
 */
public class RacingCarGameController {
    private final InputView inputView;

    public RacingCarGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        CarFactory carFactory = new CarFactory(makeNames());
        Integer counts = makeCounts();

        OutputView.printResult();
        while (counts-- > 0) {
            carFactory.giveRandomNumbers();
            OutputView.printNowCars(carFactory.makeCarsResult());
            OutputView.printOneLine();
        }

        OutputView.printWinner(carFactory.makeWinners());
    }

    private Integer makeCounts() {
        try {
            return CountValidator.makeValidCount(this.inputView.receiveCounts());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeCounts();
        }
    }

    private List<String> makeNames() {
        try {
            return NamesValidator.makeNames(this.inputView.receiveNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makeNames();
        }
    }
}
