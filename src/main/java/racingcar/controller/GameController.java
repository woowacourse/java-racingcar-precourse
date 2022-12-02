package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        cars.move(tryCount);
    }

    public void printCurrent(Cars cars) {
        outputView.printCurrent(cars.toString());
    }
}
