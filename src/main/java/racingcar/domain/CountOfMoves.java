package racingcar.domain;

public class CountOfMoves {

    private int goalCount;
    private int currentCount;

    public CountOfMoves(int finalRound) {
        this.goalCount = finalRound;
        this.currentCount = 0;
    }

    public void upperCurrentRound() {
        currentCount++;
    }

    public boolean getGoalCount() {
        return goalCount == currentCount;
    }
}
