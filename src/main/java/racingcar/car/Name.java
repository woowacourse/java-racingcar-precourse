package racingcar.car;

public class Name {
	private final String name;

	@Override
	public String toString() {
		return name;
	}

	Name(String name) {
		if (isLengthValid(name)) {
			this.name = name;
		}
		throw new IllegalArgumentException();
	}

	private boolean isLengthValid(String string) {
		final int MIN_LENGTH = 1;
		final int MAX_LENGTH = 5;
		int len = string.length();

		return MIN_LENGTH <= len && len <= MAX_LENGTH;
	}
}
