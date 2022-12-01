package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

public class OutputView {

    private static final String MOVING_MESSAGE = "-";
    private static final String EMPTY_MESSAGE = "";
    private static final String RESULT_DELIMITER = " : ";
    private static final String WINNER_SHOW_MESSAGE = "최종 우승자 : ";

    public void showResult(RacingGame racingGame) {
        List<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            printMessage(car.getName() + RESULT_DELIMITER + getMoving(car.getPosition()));
        }
        printMessage(EMPTY_MESSAGE);
    }

    public String getMoving(int count) {
        String moving = "";
        for (int i = 0; i < count; i++) {
            moving += MOVING_MESSAGE;
        }
        return moving;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
