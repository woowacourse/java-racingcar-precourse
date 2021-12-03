package racingcar.util;

public class Validator {
	private static final int CAR_NAME_RESTRICTIONS_MIN = 1;
	private static final int CAR_NAME_RESTRICTIONS_MAX = 5;
	private Parser parser = new Parser();

	public void checkCarNamesInput(String input) throws IllegalArgumentException {
		for (String carName : parser.parseCarNames(input)) {
			if (CAR_NAME_RESTRICTIONS_MAX < carName.length()) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 한다.");
			}
			if (carName.length() < CAR_NAME_RESTRICTIONS_MIN) {
				throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 한다.");
			}
		}
	}

	public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 한다.");
		}
	}
}
