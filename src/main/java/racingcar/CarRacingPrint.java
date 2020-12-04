package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingPrint {

    public static void printCarRacing(int positionCount) {
        String meter = "-";
        for (int i = 0; i < positionCount; i++) {
            System.out.printf(meter);
        }
    }

    public static List<String> printWinnerCar(List<Car> cars) {
        List<Integer> carMaxList = new ArrayList<>();
        for (Car car : cars) {
            carMaxList.add(car.getPosition());
        }

        int maxMeter = Collections.max(carMaxList);
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carMaxList.size(); i++) {
            if (maxMeter == carMaxList.get(i)) {
                winnerList.add(cars.get(i).getCarName());
            }
        }
        return winnerList;
    }
}
