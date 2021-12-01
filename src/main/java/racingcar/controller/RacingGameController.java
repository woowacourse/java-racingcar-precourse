package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingGameController {
    private Cars cars;
    private TryNumber tryNumber;

    public RacingGameController() {
        prepareCars();
        prepareTryNumber();
    }

    public void run() {

    }

    private void prepareTryNumber() {
        try {
            TryNumber tryNumber = new TryNumber(InputView.requireTryNumber());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            prepareTryNumber();
        }
        this.tryNumber = tryNumber;
    }

    private void prepareCars() {
        try {
            Cars cars = new Cars(InputView.requirePlayersName());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            prepareCars();
        }
        this.cars = cars;
    }
}
