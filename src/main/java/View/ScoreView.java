package View;

public class ScoreView {
    private static final String SYMBOL = "-";

    public ScoreView(int score) {

    }

    void showState(int score) {
        for(int index = 0; index < this.score; index++) {
            System.out.print(this.SYMBOL);
        }
    }
}
