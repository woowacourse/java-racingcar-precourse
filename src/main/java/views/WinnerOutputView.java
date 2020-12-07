package views;

import domain.Car;
import domain.RaceWinner;

public class WinnerOutputView {
    private static final String WINNER_GUIDE_MESSAGE = "최종 우승자: ";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final int WINNER_START_INDEX = 0;
    private static final int SEPARATOR_SIZE = 2;

    public static void printWinner(RaceWinner raceWinner) {
        System.out.println(WINNER_GUIDE_MESSAGE + makeWinnerNames(raceWinner));
    }

    private static String makeWinnerNames(RaceWinner raceWinner) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car car : raceWinner.getRaceWinners()) {
            winnerNames.append(car.getName());
            winnerNames.append(WINNER_NAME_SEPARATOR);
        }
        return deleteLastSeparator(winnerNames);
    }

    private static String deleteLastSeparator(StringBuilder winnerNames) {
        return winnerNames.substring(WINNER_START_INDEX, winnerNames.length() - SEPARATOR_SIZE);
    }
}
