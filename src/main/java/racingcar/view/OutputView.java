package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ATTEMPT_RESULT_MESSAGE = "%s : %s\n";
    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResultScore(Car car) {
        System.out.printf(ATTEMPT_RESULT_MESSAGE, car.getName(), car.positionToBars());
    }

    public static void printWinner(Winner winner) {
        System.out.println(WINNER_MESSAGE + winner.getWinners());
    }
}
