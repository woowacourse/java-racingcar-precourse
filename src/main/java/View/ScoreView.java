package View;

public class OutputView {
    private static final String SYMBOL = "-";

    public OutputView(int score) {

    }

    void showState(int score) {
        for(int index = 0; index < this.score; index++) {
            System.out.print(this.SYMBOL);
        }
    }
}
