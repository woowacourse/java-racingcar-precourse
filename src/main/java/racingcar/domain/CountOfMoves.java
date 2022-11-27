package racingcar.domain;

public class CountOfMoves {

    private int targetNumber;
    private int currentNumber;

    public CountOfMoves(int targetNumber) {
        validate(targetNumber);
        this.targetNumber = targetNumber;
        this.currentNumber = 0;
    }

    public void upperCurrentRound() {
        currentNumber++;
    }

    public boolean reachTargetNumber() {
        return targetNumber == currentNumber;
    }

    private void validate(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("이동횟수 1 이상이여야합니다. 입력값 : " + input);
        }
    }
}
