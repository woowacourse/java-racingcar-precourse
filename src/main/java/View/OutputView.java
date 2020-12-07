package View;

public class OutputView {
    private static final String SYMBOL = "-";

    public OutputView(int score) {

    }

    private String showScore(int score) {
        String message = "";
        for(int index = 0; index < score; index++) {
            message += this.SYMBOL;
        }
        return message;
    }


}
