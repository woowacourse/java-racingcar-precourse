package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String PROGRESS_BAR = "-";

    private OutputView() {}

    public static void printProgress(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : " + PROGRESS_BAR.repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }
}
