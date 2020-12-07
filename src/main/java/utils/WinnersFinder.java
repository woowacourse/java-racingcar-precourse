package utils;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static racegame.Constant.OUTPUT_VIEW_WINNER_DELIMITER;

public class WinnersFinder {

    public static String getWinnersStringBuffer(List<Car> carList){
        int maxPosition = getMaximumPosition(carList);
        StringBuffer winners = new StringBuffer();

        for(Car car : carList){
            if(car.getPosition() == maxPosition) {
                winners = printNameDelimiter(winners, winners.length());
                winners.append(car.getName());
            }
        }

        return winners.toString();
    }

    private static int getMaximumPosition(List<Car> carList){
        List<Integer> list = new ArrayList<>();
        for (Car car : carList) {
            list.add(car.getPosition());
        }
        return list.stream().max(Integer::compare).orElse(0);
    }

    private static StringBuffer printNameDelimiter(StringBuffer winners, int length){
        if(length >0){
            winners.append(OUTPUT_VIEW_WINNER_DELIMITER);
        }
        return winners;
    }
}
