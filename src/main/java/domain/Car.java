package domain;

public class Car {
	private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 1글자 이상, 5글자 이하를 입력해야 합니다.";
	private static final String NAME_ONLY_SPACES_ERROR_MESSAGE = "이름은 공백만으로 구성될 수 없습니다.";

	private static final int MINIMUM_NAME_LENGTH = 1;
	private static final int MAXIMUM_NAME_LENGTH = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validateLength(name);
		validateOnlySpace(name);

		this.name = name;
	}

	private void validateLength(String name) {
		int nameLength = name.length();
		if (nameLength < MINIMUM_NAME_LENGTH || nameLength > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private void validateOnlySpace(String name) {
		String spaceRemovedName = name.replace(" ", "");
		if (spaceRemovedName.length() == 0) {
			throw new IllegalArgumentException(NAME_ONLY_SPACES_ERROR_MESSAGE);
		}
	}
}
