package validation;

public class CarNameValidator implements Validator<String> {
	private static final int MAX_CHARS = 5;
	private static final String WHITE_SPACE = " ";
	private static final String EMPTY_MESSAGE = "이름이 비어있다.";
	private static final String LENGTH_MESSAGE = "이름이 " + MAX_CHARS + "자를 초과한다.";
	private static final String WHITE_SPACE_MESSAGE = "이름에 공백이 존재한다.";

	@Override
	public void validate(String name) {
		checkEmpty(name);
		checkLength(name);
		checkWhiteSpace(name);
	}

	private void checkEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	private void checkLength(String name) {
		if (name.length() > MAX_CHARS) {
			throw new IllegalArgumentException(LENGTH_MESSAGE);
		}
	}

	private void checkWhiteSpace(String name) {
		if (name.contains(WHITE_SPACE)) {
			throw new IllegalArgumentException(WHITE_SPACE_MESSAGE);
		}
	}
}
