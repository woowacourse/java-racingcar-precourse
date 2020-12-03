package racingcar;

import View.OutputView;
import exceptions.Validator;
import utils.RandomNumber;
import utils.RandomUtils;

import java.util.List;

public class Cars {

    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        Validator.validateCarsSize(cars);
        Validator.validateCarNameLength(cars);
        this.cars = cars;
    }

    public void showCurrentStatus() {
        for(Car car : cars) {
            OutputView.printCurrentStatus(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    public void progressTurn() {
        for(Car car : cars) {
            compareRandomNumberAndMove(car);
        }
    }

    private void compareRandomNumberAndMove(Car car) {
        if(RandomNumber.getRandomNumber() >= MINIMUM_NUMBER_TO_MOVE) {
            car.moveCarForward();
        }
    }


}
