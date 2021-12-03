package racingcar;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "\n실행 결과";
    private static final String COLON = " : ";
    private static final String DISTANCE = "-";
    private static final String ERROR = "[ERROR] ";
    private static final String WINNER_IS = "최종 우승자: ";
    private static final String AND = ", ";

    public static void printGameResult() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printPlayer(String carName) {
        System.out.printf(carName + COLON);
    }

    public static void printPosition(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.printf(DISTANCE);
        }
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }

    public static void printWinner(List<String> winnerList) {
        System.out.println(WINNER_IS + String.join(AND, winnerList));
    }

    public static void printPlayerAndPosition(Car car) {
        OutputView.printPlayer(car.getName());
        OutputView.printPosition(car.getPosition());
    }
}
