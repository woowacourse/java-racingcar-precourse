package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarNameAndPosition(Car car) {
        System.out.println(car.toString());
    }

    public static void printWinner(Winners winners) {
        System.out.println(WINNER_MESSAGE + winners.getWinnerNames());
    }
}
