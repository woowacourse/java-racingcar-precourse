package racingcar.utils;

import java.util.List;

public class OutputFormatter {

    final private static String DELIMITER_FIELD = " : ";
    final private static String DELIMITER_WINNER = ",";
    final private static String CAR_STATUS_BAR = "-";
    final private static String EMPTY = "";
    final private static String LINE_BREAK = "\n";
    final private static String WINNER_TAG = "최종 우승자";

    public static String converseCarStatus(int position, String name) {
        return String.join(EMPTY,
            name, DELIMITER_FIELD, generateStatusBar(position));
    }

    public static String converseGameStatus(List<String> carStatusList) {
        return String.join(LINE_BREAK, carStatusList) + LINE_BREAK;
    }

    public static String convertWinners(List<String> winners) {
        return String.join(EMPTY,
            WINNER_TAG, DELIMITER_FIELD, String.join(DELIMITER_WINNER, winners));
    }

    private static String generateStatusBar(int amount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            result.append(CAR_STATUS_BAR);
        }
        return result.toString();
    }
}
