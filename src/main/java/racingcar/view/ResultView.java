package racingcar.view;

import racingcar.RacingCars;
import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void printResult(RacingCars racingCars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars.getCars()) {
            sb.append(car.getName() + " : ")
               .append(printDistance(car))
               .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String printDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++)
            sb.append("-");

        return sb.toString();
    }
}
