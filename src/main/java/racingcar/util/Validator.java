package racingcar.util;

public class Validator {
	private static final int CAR_NAME_RESTRICTIONS_MIN = 1;
	private static final int CAR_NAME_RESTRICTIONS_MAX = 5;
	private static final String SPACE = " ";
	private final Parser parser = new Parser();

	public void checkCarNamesInput(String input) throws IllegalArgumentException {
		checkLastIndexOfMark(input);
		for (String carName : parser.parseCarNames(input)) {
			checkLength(carName);
			checkSpace(carName);
		}
	}

	public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 한다.");
		}
	}

	private void checkLastIndexOfMark(String input) throws IllegalArgumentException {
		if (input.lastIndexOf(",") == input.length() - 1) {
			throwMinLengthException();
		}
	}

	private void checkLength(String carName) throws IllegalArgumentException {
		if (CAR_NAME_RESTRICTIONS_MAX < carName.length()) {
			throwMaxLengthException();
		}
		if (carName.length() < CAR_NAME_RESTRICTIONS_MIN) {
			throwMinLengthException();
		}
	}

	private void throwMinLengthException() throws IllegalArgumentException {
		throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_RESTRICTIONS_MIN + "글자 이상이어야 한다.");
	}

	private void throwMaxLengthException() throws IllegalArgumentException {
		throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_RESTRICTIONS_MAX + "글자 이하여야 한다.");
	}

	private void checkSpace(String carName) throws IllegalArgumentException {
		if (carName.contains(SPACE)) {
			throwSpaceException();
		}
	}

	private void throwSpaceException() throws IllegalArgumentException {
		throw new IllegalArgumentException("[ERROR] 자동차 이름안에는 공백이 있어서는 안됩니다.");
	}
}
