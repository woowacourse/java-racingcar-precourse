package View;

public class OutputView {
    private static final String SYMBOL = "-";

    public OutputView(int score) {

    }

    void showScore(int score) {
        for(int index = 0; index < score; index++) {
            System.out.print(this.SYMBOL);
        }
    }
}
