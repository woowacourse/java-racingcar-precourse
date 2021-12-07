package racingcar;

import java.util.List;

public class OutputManager {
    private static final String CAR_NAMES_INPUT_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_COMMENT = "시도할 회수는 몇회인가요?";
    private static final String CAR_POSITION_FORMAT = "%s : %s";
    private static final String WINNER_NAMES_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAME_JOINER_DELIMITER = ", ";

    public void printCarNamesInputComment() {
        System.out.println(CAR_NAMES_INPUT_COMMENT);
    }

    public void printTryCountInputComment() {
        System.out.println(TRY_COUNT_INPUT_COMMENT);
    }

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
