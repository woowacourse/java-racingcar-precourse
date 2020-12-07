package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String COLON = " : ";
    private static final String SCORE = "_";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";
    private static final String SPLIT_MARKER = ", ";
    private static final String BLANK = "\0";

    private OutputView() {
    }

    public static void printWinner(List<String> winnerList) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(SPLIT_MARKER, winnerList));
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> carList) {
        for (int idx = 0; idx < carList.size(); idx++) {
            printCarPosition(carList.get(idx));
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + COLON);
        System.out.println(new String(new char[car.getPosition()]).replace(BLANK,SCORE));
    }
}
