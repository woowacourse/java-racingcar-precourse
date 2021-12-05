package racingcar.utils;

import java.util.List;

public class OutputFormatter {

    final private static String FIELD_DELIMITER = " : ";
    final private static String CAR_STATUS_BAR = "-";
    final private static String WINNER_DELIMITER = ",";
    final private static String LINE_BREAK = "\n";
    final private static String WINNER_TAG = "최종 우승자";

    public static String converseCarStatus(int position, String name) {
        return name + FIELD_DELIMITER + generateStatusBar(position);
    }

    private static String generateStatusBar(int amount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            result.append(CAR_STATUS_BAR);
        }
        return result.toString();
    }

    public static String converseGameStatus(List<String> carStatusList) {
        return String.join(LINE_BREAK, carStatusList) + LINE_BREAK;
    }

    public static String convertWinners(List<String> winners) {
        return WINNER_TAG + FIELD_DELIMITER + String.join(WINNER_DELIMITER, winners);
    }
}
