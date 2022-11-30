package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.GameResult;

public class OutputView {

    private static final String RESULT_OF_PLAY = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COLON = ":";
    private static final String BLANK = " ";
    private static final String MOVING = "-";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_OF_PLAY);
    }

    public void printRoundResult(GameResult gameResult) {
        Map<String, Integer> playerPosition = gameResult.getPlayerPosition();
        for (String name : playerPosition.keySet()) {
            System.out.print(name + BLANK + COLON + BLANK);
            for (int i = 0; i < playerPosition.get(name); i++) {
                System.out.print(MOVING);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printFinalWinner(GameResult gameResult) {
        List<String> finalWinner = gameResult.getFinalWinner();
        System.out.println(FINAL_WINNER + BLANK + COLON + BLANK + String.join(", ", finalWinner));
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }
}
