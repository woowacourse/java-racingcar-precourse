package domain;

public class InputValidator {
	private static final int MAX_NAME_LENGHT = 5;
	private static final char MIN_CH = '0';
	private static final char MAX_CH = '9';

	public boolean isValidCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (!checkCarNameLength(carName)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidNumberOfAttemp(String numberOfAttemp) {
		if (isBlank(numberOfAttemp) && isPositiveInteger(numberOfAttemp)) {
			return true;
		}
		System.out.println("시도할 회수는 1이상의 정수로 입력해주세요.");
		return false;
	}
	
	private boolean checkCarNameLength(String carName) {
		if (isBlank(carName) && (carName.length() <= MAX_NAME_LENGHT)) {
			return true;
		}
		System.out.println("자동차 이름은 1글자 이상 5글자 이하로 입력해주세요.");
		return false;
	}
	
	private boolean isPositiveInteger(String numberOfAttemp) {
		char[] ch_number = numberOfAttemp.toCharArray();
		
		/* 각 자리수가 정수인지 확인 */
		for (char ch : ch_number) {
			if ((MIN_CH > ch) || (ch > MAX_CH)) {
				return false;
			}
		}
		if (Integer.parseInt(numberOfAttemp) == 0) {
			return false;
		}
		
		return true;
	}

	private boolean isBlank(String str) {
		if (str.length() == 0) {
			return false;
		}
		return true;
	}
}
