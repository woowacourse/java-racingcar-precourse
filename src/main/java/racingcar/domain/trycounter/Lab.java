package racingcar.domain.trycounter;

public class Lab {

	private static final String LIMIT_MUST_BE_NUMBER = "[0-9]+";

	private final int limit;
	private int current = 0;

	public Lab(String input) {
		validate(input);
		limit = Integer.parseInt(input);
	}

	private void validate(String input) {
		isNumeric(input);
		isInteger(input);
	}

	private void isNumeric(String input) {
		if (!input.matches(LIMIT_MUST_BE_NUMBER)) {
			throw new LabMustBeNumberException();
		}
	}

	private void isInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new LabMustIntegerRangeException();
		}
	}

}
