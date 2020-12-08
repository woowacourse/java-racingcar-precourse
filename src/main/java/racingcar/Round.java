package racingcar;

public class Round {

    public static final int DEFAULT_ROUND = 1;
    private int round;

    public Round(int round) {
        this.round = round;
    }

    public int getRoundValue() {
        return round;
    }

    public void setRoundValue(int round) {
        this.round = round;
    }
}
