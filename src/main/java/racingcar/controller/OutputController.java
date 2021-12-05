package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputController {
    public static void finalWinner(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        String[] winnerArray = getWinnerList(carList, maxPosition);
        printWinner(winnerArray);
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

    private static String[] getWinnerList(List<Car> carList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList.toArray(new String[winnerList.size()]);
    }

    private static void printWinner(String[] winnerArray) {
        String join = String.join(", ", winnerArray);
        System.out.println("최종 우승자 : " + join);
    }
}
