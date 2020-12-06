package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.GameBoard;

import java.util.List;

public class OutputView {
    private static final String COLON = " : ";
    private static final String SCORE = "_";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private OutputView() {
    }

    public static void printScoreboard(int attemptCount, GameBoard gameBoard) {
        printResultMessage();
        for (int round = 0; round < attemptCount; round++) {
            printRoundResult(gameBoard.runRound());
        }
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static void printRoundResult(List<Car> carList) {
        for (int idx = 0; idx < carList.size(); idx++) {
            printScore(carList.get(idx));
        }
        System.out.println();
    }

    private static void printScore(Car car) {
        System.out.print(car.getName() + COLON);
        System.out.println(new String(new char[car.getPosition()]).replace("\0",SCORE));
    }
}
