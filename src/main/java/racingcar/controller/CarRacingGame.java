package racingcar.controller;


import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGame {
    public void start() {
        Cars cars = new Cars();

        setCarsName(cars);
        setTryNumber(cars);

        printAllTry(cars);
        printWinner(cars);
    }

    private void setCarsName(Cars cars) {
        try {
            cars.addCars(InputView.printSetCarsNameMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setCarsName(cars);
        }
    }

    private void setTryNumber(Cars cars) {
        try {
            cars.setTryNumber(InputView.printSetTryNumberMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setTryNumber(cars);
        }
    }

    private void printAllTry(Cars cars) {
        for (int i = 0; cars.getTryNumber() > i; i++) {
            printCarsPosition(cars);
        }
    }

    private void printCarsPosition(Cars cars) {
        for (Car car : cars.getCarList()) {
            car.SelectMoveOrStop();
            OutputView.printCarName(car.getName());
            OutputView.printCarPosition(car.getPosition());
            OutputView.printSpace();
        }
        OutputView.printSpace();
    }

    private void printWinner(Cars cars) {
        OutputView.printWinner(getWinner(cars));
    }

    private String getWinner(Cars cars) {
        return cars.getWinner(cars.getCarsPosition());
    }
}
