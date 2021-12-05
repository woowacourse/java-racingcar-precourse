package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputController {
    public static void finalWinner(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        List<Car> winnerList = getWinnerList(carList, maxPosition);
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

    private static List<Car> getWinnerList(List<Car> carList, int maxPosition) {
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition){
                winnerList.add(car);
            }
        }
        return winnerList;
    }
}
