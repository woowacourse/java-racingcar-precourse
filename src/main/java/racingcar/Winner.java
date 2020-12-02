package racingcar;

import java.util.List;

public class Winner {
    private static int winnerPosition = 0;

    public static void setWinnerPosition(List<Car> carList) {
        for (Car car : carList) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
        System.out.println("winnerPosition : " + winnerPosition);
    }
}
