package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.NameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.CarConstant.*;
import static util.CarConstant.NUMBER_MOVE_FORWARD;

public class Cars {
    private final List<Car> carList = Collections.synchronizedList(new ArrayList<>());

    private Cars() {
    }

    public static Cars getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private final static Cars INSTANCE = new Cars();
    }

    public void saveCars(String input) {
        validateNames(input).forEach(name ->
                carList.add(new Car(name)));
    }

    public void updateCarPosition() {
        carList.forEach(car ->
                moveForward(car, Randoms.pickNumberInRange(MIN, MAX)));
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public void removeAll() {
        int size = carList.size();
        for (int i = 0; i < size; i++) {
            carList.remove(ZERO);
        }
    }

    private int findMaxPosition() {
        int max = ZERO;
        for (Car car : carList) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    private void moveForward(Car car, int randomNumber) {
        if (checkMoveForward(randomNumber)) {
            car.goForward();
        }
    }

    private boolean checkMoveForward(int randomNumber) {
        if (randomNumber >= NUMBER_MOVE_FORWARD) {
            return true;
        }
        return false;
    }

    private List<String> validateNames(String input) {
        String[] tempCars = input.split(DELIMITER);
        NameValidator.isRightName(tempCars);
        return Arrays.asList(tempCars);
    }


}
