package racingcar.car;

class Name {
	private final String name;

	@Override
	public String toString() {
		return name;
	}

	Name(String name) {
		if (!isLengthValid(name)) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
		}
		this.name = name;
	}

	private boolean isLengthValid(String string) {
		final int MIN_LENGTH = 1;
		final int MAX_LENGTH = 5;
		int len = string.length();

		return MIN_LENGTH <= len && len <= MAX_LENGTH;
	}
}
