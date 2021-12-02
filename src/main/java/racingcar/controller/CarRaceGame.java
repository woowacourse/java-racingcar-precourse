package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {
    public void start() {
        Cars cars = new Cars();
        getCarsName(cars);
    }

    public void getCarsName(Cars cars){
        try{
            cars.addCar(InputView.printGetCarsNameMessage());
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            getCarsName(cars);
        }
    }
}
