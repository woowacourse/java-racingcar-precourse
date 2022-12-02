package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public String[] readNames() {
        return inputView.readNames();
    }

    public Cars createCars(String[] names) {
        return new Cars(names);
    }

    public Long readTryCount() {
        return inputView.readTryCount();
    }

    public TryCount createTryCount(Long tryCount) {
        return new TryCount(tryCount);
    }

    public void race(Cars cars, TryCount tryCount) {
        outputView.printMessage("\n실행 결과");

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move();
            outputView.printCurrent(cars.toString());
        }
    }

    public void finish(Cars cars) {
        List<String> winners = cars.winners();
        outputView.printResult(winners);
    }
}
