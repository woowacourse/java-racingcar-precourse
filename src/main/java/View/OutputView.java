package View;

import java.util.List;

public class OutputView {
    private static final String SYMBOL = "-";
    private static final String DELIMITER = ",";

    public OutputView() {

    }

    public void showState(String name, int score) {
        System.out.println(name + " : "+ scoreMessage(score));
    }

    public void showWinners(List<String> winners) {
        String message = "";
        for(String winner: winners) {
            message += winner;
            message += DELIMITER;
        }

        System.out.println(message);
    }
    private String scoreMessage(int score) {
        String message = "";
        for(int index = 0; index < score; index++) {
            message += this.SYMBOL;
        }
        return message;
    }


}
