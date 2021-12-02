package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Car> carList;

    public static void initialize() {
        carList = InputUtils.returnCarList();
        int attemp = InputUtils.getAttempNum();

        start(attemp);
    }

    private static void start(int attemp) {
        while (attemp > 0) {
            for (Car car : carList) {
                car.moveForward();
            }
            attemp--;
            PrintUtils.printByAttemp(carList);
        }

        PrintUtils.printFinalResult(carList);
    }
}
