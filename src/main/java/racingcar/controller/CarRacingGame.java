package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGame {
    public void start() {
        Cars cars = new Cars();

        setCarsName(cars);
        setTryNumber(cars);
    }

    public void setCarsName(Cars cars) {
        try {
            cars.addCar(InputView.printSetCarsNameMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setCarsName(cars);
        }
    }

    public void setTryNumber(Cars cars) {
        try {
            cars.setTryNumber(InputView.printSetTryNumberMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setTryNumber(cars);
        }
    }
}
