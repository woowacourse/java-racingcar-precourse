package racingcar.domain;

public class CountOfMoves {

    private int goalCount;
    private int currentCount;

    public CountOfMoves(int finalRound) {
        validate(finalRound);
        this.goalCount = finalRound;
        this.currentCount = 0;
    }

    public void upperCurrentRound() {
        currentCount++;
    }
    
    public boolean getGoalCount() {
        return goalCount == currentCount;
    }

    private void validate(int finalRound) {
        if (finalRound <= 0) {
            throw new IllegalArgumentException("이동횟수 1 이상이여야합니다. 입력값 : " + finalRound);
        }
    }
}
