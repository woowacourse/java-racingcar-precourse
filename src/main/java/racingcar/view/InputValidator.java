package racingcar.view;

import static util.Constants.*;

import java.util.List;

public class InputValidator {
	private static final InputValidator inputValidator = new InputValidator();

	private InputValidator() {

	}

	public static InputValidator getInputValidator() {
		return inputValidator;
	}

	public boolean checkNameExceptions(List<String> carNamesList) {
		return checkLongNameException(carNamesList) && checkBlankNameException(carNamesList);
	}

	public boolean checkRepetitionNumberExceptions(String repetitionNumber) {
		return checkNotNaturalNumberException(repetitionNumber);
	}

	private boolean checkNotNaturalNumberException(String repetitionNumber) {
		try {
			if (repetitionNumber.chars().anyMatch(number -> !Character.isDigit(number))) {
				System.out.println(REPETITION_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean checkLongNameException(List<String> carNamesList) {
		try {
			if (carNamesList.stream().anyMatch(carName -> carName.length() > MAXIMUM_NAME_LENGTH)) {
				System.out.println(LONG_CAR_NAME_INPUT_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean checkBlankNameException(List<String> carNamesList) {
		try {
			if (carNamesList.stream().anyMatch(carName -> carName.length() == 0)) {
				System.out.println(BLANK_CAR_NAME_INPUT_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
