package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingPrint {
    private final static int PRINT_CAR_RACING_INDEX = 0;
    private final static int PRINT_WINNER_CAR_INDEX = 0;

    public static void printCarRacing(int positionCount) {
        String meter = "-";
        for (int i = PRINT_CAR_RACING_INDEX; i < positionCount; i++) {
            System.out.print(meter);
        }
    }

    public static List<String> printWinnerCar(List<Car> cars) {
        List<Integer> carMaxList = new ArrayList<>();
        for (Car car : cars) {
            carMaxList.add(car.getPosition());
        }

        int maxMeter = Collections.max(carMaxList);
        List<String> winnerList = new ArrayList<>();
        for (int i = PRINT_WINNER_CAR_INDEX; i < carMaxList.size(); i++) {
            if (maxMeter == carMaxList.get(i)) {
                winnerList.add(cars.get(i).getCarName());
            }
        }
        return winnerList;
    }
}
