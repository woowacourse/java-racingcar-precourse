package racingcar;

import java.util.ArrayList;

public class Winner {
    public static ArrayList<String> getWinner(ArrayList<Car> carList) {
        Integer maxPosition = getMaxPosition(carList);
        ArrayList<String> winnerList = new ArrayList<String>();

        carList.forEach(car -> {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        });
        return winnerList;
    }

    public static Integer getMaxPosition(ArrayList<Car> carList) {
        Integer maxValue = 0;
        for (Car car: carList) {
            if (car.getPosition() > maxValue) {
                maxValue = car.getPosition();
            }
        }
        return maxValue;
    }
}
