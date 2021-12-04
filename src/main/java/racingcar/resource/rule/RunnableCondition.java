package racingcar.resource.rule;

public enum RunnableCondition {

	MINIMUM(4);

	private final int number;

	RunnableCondition(int number) {
		this.number = number;
	}

	public static boolean isRunnable(int number) {
		return (number >= MINIMUM.number);
	}

}
