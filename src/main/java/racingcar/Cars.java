package racingcar;

import View.OutputView;
import exceptions.Validator;
import utils.RandomNumber;
import utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        Validator.validateCarsSize(cars);
        Validator.validateCarNameLength(cars);
        this.cars = cars;
    }

    public void showCurrentStatus() {
        OutputView.printCurrentStatus(cars);
    }

    public void progressTurn() {
        for (Car car : cars) {
            compareRandomNumberAndMove(car);
        }
    }

    public List<Car> findWinners() {
        int winnersPosition = findMaxPosition();
        List<Car> winners = cars.stream().filter(car -> car.getPosition() == winnersPosition).collect(Collectors.toList());
        return winners;
    }

    private int findMaxPosition() {
        return cars.stream().mapToInt(car -> car.getPosition()).max().getAsInt();
    }

    private void compareRandomNumberAndMove(Car car) {
        if (RandomNumber.getRandomNumber() >= MINIMUM_NUMBER_TO_MOVE) {
            car.moveCarForward();
        }
    }


}
