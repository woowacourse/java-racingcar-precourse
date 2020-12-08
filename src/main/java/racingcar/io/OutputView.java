package racingcar.io;

import java.util.LinkedList;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RACING_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RACING_CAR_NAME_DELIMITER = ", ";

    public void printRacingResultMessage() {
        System.out.println('\n' + RACING_RESULT_OUTPUT_MESSAGE);
    }

    public void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printCarNames(List<Car> cars) {
        System.out.print(RACING_WINNER_MESSAGE);
        List<String> carNames = new LinkedList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        System.out.println(String.join(RACING_CAR_NAME_DELIMITER, carNames));
    }

}
