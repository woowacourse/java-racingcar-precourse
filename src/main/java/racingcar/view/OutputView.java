package racingcar.view;

import java.util.List;
import racingcar.domain.RacingResult;

public class OutputView {
    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String POSITION_UI = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public void printWay(RacingResult result) {
        List<String> carNames = result.getCarNames();
        for (String carName : carNames) {
            int position = result.getPosition(carName);
            System.out.printf(RESULT_FORMAT, carName, positionMap(position));
        }
        System.out.println();
    }

    private String positionMap(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION_UI);
        }
        return sb.toString();
    }

    public void printWinner(RacingResult winner) {
        String collect = String.join(WINNER_DELIMITER, winner.getCarNames());
        System.out.printf(WINNER_MESSAGE_FORMAT, collect);
    }

    public void printError(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
