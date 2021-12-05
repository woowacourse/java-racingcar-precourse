package racingcar.utils;

import java.util.List;

public class OutputFormatter {

    final private static String CAR_STATUS_DELIMITER = " : ";
    final private static String CAR_STATUS_BAR = "-";
    final private static String LINE_BREAK = "\n";

    public static String converseCarStatus(int position, String name) {
        return name + CAR_STATUS_DELIMITER + generateStatusBar(position);
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

}
