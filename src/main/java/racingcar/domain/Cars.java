package racingcar.domain;

import racingcar.view.OutputView;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int ZERO = 0;
    private static final int NINE = 9;
    private static final int FOUR = 4;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 자동차 이름을 입력해주세요";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateExistCars(cars);
        this.cars = cars;
    }

    private void validateExistCars(List<Car> cars) {
        if (cars.size() == ZERO) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void goOrStopCars() {
        for (Car car : cars) {
            if(isGo()) {
                car.goCar();
            }
        }
    }

    private boolean isGo() {
        int randomNumber = RandomUtils.nextInt(ZERO, NINE);
        if(randomNumber >= FOUR) {
            return true;
        }
        return false;
    }

    public Winner getWinnerCars() {
        List<Car> winner = new ArrayList<>();
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            if(car.isMaxPosition(maxPosition)) {
                winner.add(car);
            }
        }
        return new Winner(winner);
    }

    public void printResultCars() {
        for (Car car : cars) {
            OutputView.printResultScore(car);
        }
        System.out.println();
    }
}
