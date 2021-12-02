package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private Cars cars;
    private TryNumber tryNumber;

    public RacingGameController() {
        prepareCars();
        prepareTryNumber();
    }

    public void run() {
        while (!this.tryNumber.finish()) {
            this.cars.move();
            tryNumber.minus();
            OutputView.printCurrentCarsPosition(cars.cars());
        }
        OutputView.printWinner(cars.cars());
    }

    private void prepareTryNumber() {
        try {
            this.tryNumber = new TryNumber(InputView.requireTryNumber());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            prepareTryNumber();
        }

    }

    private void prepareCars() {
        try {
            this.cars = new Cars(InputView.requirePlayersName());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            prepareCars();
        }
    }
}
