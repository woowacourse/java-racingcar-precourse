package domain;

import java.util.Objects;

public class Name {
	private static final String LENGTH_ERROR_MESSAGE = "이름은 1글자 이상, 5글자 이하를 입력해야 합니다.";
	private static final String SPACE_INCLUDED_ERROR_MESSAGE = "이름에 공백이 포함될 수 없습니다.";

	private static final String SPACE = " ";

	private static final int MINIMUM_LENGTH = 1;
	private static final int MAXIMUM_LENGTH = 5;

	private final String name;

	public Name(String name) {
		validateLength(name);
		validateSpaceIncluded(name);

		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	private void validateLength(String name) {
		int nameLength = name.length();
		if (nameLength < MINIMUM_LENGTH || nameLength > MAXIMUM_LENGTH) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}
	}

	private void validateSpaceIncluded(String name) {
		if (name.contains(SPACE)) {
			throw new IllegalArgumentException(SPACE_INCLUDED_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Name otherName = (Name)o;
		return this.name.equals(otherName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}
