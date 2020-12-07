package View;

public class OutputView {
    private static final String SYMBOL = "-";

    public OutputView(int score) {

    }

    private String scoreMessage(int score) {
        String message = "";
        for(int index = 0; index < score; index++) {
            message += this.SYMBOL;
        }
        return message;
    }

    public void showState(String name, int score) {
        System.out.println(name + " : "+ scoreMessage(score));
    }
}
