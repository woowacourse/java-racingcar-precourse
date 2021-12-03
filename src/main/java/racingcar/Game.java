package racingcar;

import utils.InputUtils;
import utils.PrintUtils;

import java.util.List;

import static constant.Constant.RESULT_MESSAGE;

public class Game {
    private static List<Car> carList;

    public static void initialize() {
        carList = InputUtils.returnCarList();
        int attemp = InputUtils.getAttempNum();

        start(attemp);
    }

    private static void start(int attemp) {
        System.out.println(RESULT_MESSAGE);
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
