package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.domain.ScoreBoard;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ScoreBoard scoreBoard;

    public RacingController() {
        outputView = new OutputView();
        inputView = new InputView(outputView);
        scoreBoard = new ScoreBoard();
    }

    public void run() {
        CarGroup cars = repeat(inputView::inputCarName);
        Integer tryCount = repeat(inputView::inputTryCount);
        outputView.printRacingStart();

        IntStream.range(0, tryCount).forEach(index -> {
            cars.moveAll();
            String log = scoreBoard.toPositionMessage(cars);
            outputView.printRacingLog(log);
        });
        outputView.printWinner(scoreBoard.getWinner(cars));
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
