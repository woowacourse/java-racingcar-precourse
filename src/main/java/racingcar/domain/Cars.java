package racingcar.domain;

import racingcar.view.OutputView;
import utils.RandomUtils;

import java.util.*;

public class Cars {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_NUMBER = 4;
    private static final String NAME_DUPLICATE_ERROR = "[ERROR] 같은 자동차 이름은 사용할 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<String> duplicateCheckSet = new HashSet<>();
        for (Car car : cars) {
            duplicateCheckSet.add(car.getName());
        }
        if(duplicateCheckSet.size() != cars.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
    }

    public void moveOrStop() {
        for (Car car : cars) {
            if(isMove()) {
                car.moveCar();
            }
        }
    }

    private boolean isMove() {
        int randomNumber = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
        if(randomNumber >= MOVE_NUMBER) {
            return true;
        }
        return false;
    }

    public Winners getWinnerCars() {
        List<Car> winners = new ArrayList<>();
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            if(!car.isMaxPosition(maxPosition)) {
                break;
            }
            winners.add(car);
        }
        return new Winners(winners);
    }

    public void printResultCars() {
        for (Car car : cars) {
            OutputView.printCarNameAndPosition(car);
        }
        System.out.println();
    }
}
