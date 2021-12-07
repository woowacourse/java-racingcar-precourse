package racingcar.domain;

public class AttemptNumber {
	private int attemptNumber;

	public AttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public boolean isAttemptRemained() {
		return attemptNumber > 0;
	}

	public void reduceAttemptNumber() {
		this.attemptNumber--;
	}
}
