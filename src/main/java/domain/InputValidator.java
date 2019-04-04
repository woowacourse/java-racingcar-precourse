package domain;

public class InputValidator {
	private static final int MAX_NAME_LENGHT = 5;

	public boolean isValidCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (!checkCarNameLength(carName)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkCarNameLength(String carName) {
		if (isBlank(carName) && (carName.length() < MAX_NAME_LENGHT)) {
			return true;
		}
		System.out.println("자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.");
		return false;
	}

	private boolean isBlank(String str) {
		if (str.length() == 0) {
			return false;
		}
		return true;
	}
}
