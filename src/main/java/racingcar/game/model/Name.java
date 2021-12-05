package racingcar.game.model;

import java.util.Objects;

import racingcar.common.message.ExceptionMessage;

public class Name {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public Name(final String name) {
		isValidNullOrEmpty(name);
		isValidLength(name);
		this.name = name;
	}

	private void isValidNullOrEmpty(final String name) {
		if (Objects.isNull(name) || name.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY_OR_NULL_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private void isValidLength(final String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_FORMAT_EXCEPTION_MESSAGE.getMessage());
		}

	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Name name = (Name)o;
		return Objects.equals(this.name, name.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
