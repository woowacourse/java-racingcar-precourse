package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runGame() {
        askCarName();
    }

    private Cars askCarName() {
        outputView.printInputCarName();
        return new ReEnterProcessor<>(inputView::readCarName, outputView::printExceptionMessage).process();
    }
}
