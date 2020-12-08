package View;

import java.util.List;

public class OutputView {

    private static final String SYMBOL = "-";
    private static final String DELIMITER = ",";
    private static final String FINAL_WINNER = "최종 우승자: ";

    public OutputView() {

    }

    public void showState(String name, int score) {
        System.out.println(name + " : "+ scoreMessage(score));
    }

    public void showWinners(List<String> winners) {
        String message = String.join(this.DELIMITER, winners);
        System.out.println(this.FINAL_WINNER + message);
    }

    public void printLine() {
        System.out.println();
    }

    private String scoreMessage(int score) {
        String message = "";
        for(int index = 0; index < score; index++) {
            message += this.SYMBOL;
        }
        return message;
    }
}
