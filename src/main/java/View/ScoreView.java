package View;

public class ScoreView {
    private static final String SYMBOL = "-";
    private int score = 0;

    public ScoreView(int score) {
        this.score = score;
    }

    void showScore() {
        for(int index = 0; index < this.score; index++) {
            System.out.print(this.SYMBOL);
        }
    }
}
