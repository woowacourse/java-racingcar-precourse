package racingcar.controller;

import racingcar.domain.Car;

import java.util.List;

public class OutputController {
    public static void finalWinner(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);

    }

    public static int findMaxPosition(List<Car> carList) {
        int maxNum = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }
}
