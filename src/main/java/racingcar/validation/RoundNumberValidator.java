package racingcar.validation;

public class RoundNumberValidator {
	private static final int MIN_ROUND_NUMBER = 1;
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_DIGIT_MESSAGE = "양수의 숫자가 아닌 문자는 입력할 수 없다.";
	private static final String ROUND_LESS_THAN_MIN_MESSAGE = "1보다 큰 수를 입력해야한다.";
	private String number;

	public boolean isValidNumberInput(String roundNumber) {
		this.number = roundNumber;
		try {
			validateNumberInput();
			validateNumberInRange();
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateNumberInput() {
		if (number.chars().allMatch(Character::isDigit) == false) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIGIT_MESSAGE);
		}
	}

	private void validateNumberInRange() {
		if (Integer.parseInt(number) < MIN_ROUND_NUMBER) {
			throw new IllegalArgumentException(ERROR_MESSAGE + ROUND_LESS_THAN_MIN_MESSAGE);
		}
	}

}
