package racingcar.domain.model;

public class CountOfMoves {

    private static final int TARGET_NUMBER_MINIMUM_VALUE = 1;
    private static final int CURRENT_NUMBER_DEFAULT_VALUE = 0;

    private int targetNumber;
    private int currentNumber;

    public CountOfMoves(int targetNumber) {
        validate(targetNumber);
        this.targetNumber = targetNumber;
        this.currentNumber = CURRENT_NUMBER_DEFAULT_VALUE;
    }

    public void upperCurrentRound() {
        currentNumber++;
    }

    public boolean reachTargetNumber() {
        return targetNumber == currentNumber;
    }

    private void validate(int input) {
        if (input < TARGET_NUMBER_MINIMUM_VALUE) {
            throw new IllegalArgumentException("이동횟수 1 이상이여야합니다. 입력값 : " + input);
        }
    }
}
