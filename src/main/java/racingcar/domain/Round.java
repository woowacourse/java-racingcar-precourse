package racingcar.domain;

public class Round {
    private final int finalRound;
    private int tempRound = 0;

    public Round(int finalRound) {
        this.finalRound = finalRound;
    }

    public void next() {
        tempRound++;
    }

    public boolean isFinish() {
        if (tempRound == finalRound) return true;
        return false;
    }

    public int getFinalRound() {
        return finalRound;
    }
}
