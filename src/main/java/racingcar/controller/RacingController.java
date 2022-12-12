package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        outputView = new OutputView();
        inputView = new InputView(outputView);
    }

    public void run() {
        CarGroup cars = repeat(inputView::inputCarName);
        TryCount tryCount = repeat(inputView::inputTryCount);

        outputView.printRacingStart();
        IntStream.range(0, tryCount.getCount()).forEach(index -> {
            cars.moveAll();
            outputView.printRacingLog(cars);
        });

        outputView.printWinner(cars);
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
