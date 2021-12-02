package racingcar.validator;

public class TryCountValidator {

	public void validate(String tryCountString) throws IllegalArgumentException {
		keepDigitValue(tryCountString);
	}

	private void keepDigitValue(String tryCountString) throws IllegalArgumentException {
		for (int i = 0; i < tryCountString.length(); i++) {
			char c = tryCountString.charAt(i);

			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
	}
}
