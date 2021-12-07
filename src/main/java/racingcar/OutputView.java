package racingcar;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "\n실행결과";
    private static final String COLON = " : ";
    private static final String DISTANCE = "-";
    private static final String ERROR = "[ERROR]";
    private static final String WINNER_CAR_NAME_PRINT = "최종우승자: ";
    private static final String COMMA = ", ";

    public static void printGameResult() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printCarName(String carName) {
        System.out.print(carName + COLON);
    }

    public static void printPosition(int distance) {
        StringBuilder carPosition = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            carPosition.append(DISTANCE);
        }
        System.out.println(carPosition);
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }

    public static void printWinner(List<String> winnerList) {
        StringBuilder printWinnerMessage = new StringBuilder();
        printWinnerMessage.append(WINNER_CAR_NAME_PRINT);
        for (int idx = 0; idx < winnerList.size() - 1; idx++) {
            printWinnerMessage.append(winnerList.get(idx));
            printWinnerMessage.append(COMMA);
        }
        printWinnerMessage.append(winnerList.get(winnerList.size() - 1));
        System.out.println(printWinnerMessage);
    }
}