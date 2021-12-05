package racingcar.domain;

public class AttemptNumber {
	private static int numberOfRuns = 0;
	private final int attemptNumber;

	public AttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public boolean isAttemptRemained() {
		boolean result = (attemptNumber != numberOfRuns);
		numberOfRuns++;
		return result;
	}
}
