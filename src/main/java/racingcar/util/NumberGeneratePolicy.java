package racingcar.util;

public abstract class NumberGeneratePolicy {
	protected static final int MINIMUM_DRIVE = 0;
	protected static final int MAXIMUM_DRIVE = 9;

	abstract public int generateNumber();
}
