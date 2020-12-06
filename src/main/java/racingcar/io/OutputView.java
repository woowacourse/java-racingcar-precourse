package racingcar.io;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RACING_RESULT_OUTPUT_MESSAGE = "실행 결과";

    public static void printRacingResultMessage() {
        System.out.println('\n' + RACING_RESULT_OUTPUT_MESSAGE);
    }

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

}
