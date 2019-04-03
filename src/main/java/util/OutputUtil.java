package util;

import view.OutputView;

import java.util.List;

public class OutputUtil {

    public static void printWinners(List<String> winners) {
        String winnersString = convertListToString(winners);
        OutputView.printWinner(winnersString);
    }

    private static String convertListToString(List<String> winners) {
        String convertedString = String.join(",", winners);
        return convertedString;
    }
}
