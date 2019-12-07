package validation;

public class CarNameValidator implements Validator<String> {
	private static final int MAX_CHARS = 5;
	private static final String WHITE_SPACE = " ";

	@Override
	public void validate(String name) {
		checkEmpty(name);
		checkLength(name);
		checkWhiteSpace(name);
	}

	private void checkEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("이름이 비어있다.");
		}
	}

	private void checkLength(String name) {
		if (name.length() > MAX_CHARS) {
			throw new IllegalArgumentException("이름이 " + MAX_CHARS + "자를 초과한다.");
		}
	}

	private void checkWhiteSpace(String name) {
		if (name.contains(WHITE_SPACE)) {
			throw new IllegalArgumentException("이름에 공백이 존재한다.");
		}
	}
}
