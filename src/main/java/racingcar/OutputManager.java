package racingcar;

import java.util.List;

public class OutputManager {
    private static final String CAR_POSITION_FORMAT = "%s : %s";
    private static final String WINNER_NAMES_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAME_JOINER_DELIMITER = ", ";

    public void printCurrentCarPosition(Car car) {
        System.out.printf(CAR_POSITION_FORMAT, car.getName(), getPositionString(car.getPosition()));
        addNewLine();
    }

    private String getPositionString(int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printWinnerNames(List<String> winnerNames) {
        String joinedWinnerNames = String.join(WINNER_NAME_JOINER_DELIMITER, winnerNames);

        System.out.printf(WINNER_NAMES_FORMAT, joinedWinnerNames);
        addNewLine();
    }

    public void printRoundSplitter() {
        addNewLine();
    }

    private void addNewLine() {
        System.out.println();
    }
}
