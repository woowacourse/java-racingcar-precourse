package racingcar.util;

import java.util.List;

public class Validator {
	private static final int CAR_NAME_RESTRICTIONS_MIN = 1;
	private static final int CAR_NAME_RESTRICTIONS_MAX = 5;
	private static final String SPACE = " ";
	private final Parser parser = new Parser();

	public void checkCarNamesInput(String input) throws IllegalArgumentException {
		checkEmptyAndThrowException(input);
		checkLastIndexAndThrowException(input);
		List<String> carNameList = parser.parseCarNames(input);
		checkCarNameListDuplicationAndThrowException(carNameList);
		for (String carName : carNameList) {
			checkLengthAndThrowException(carName);
			checkSpaceAndThrowException(carName);
		}
	}

	public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
		checkEmptyAndThrowException(input);
		checkCharAndThrowException(input);
	}

	private void checkCharAndThrowException(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자여야 합니다.");
		}
	}

	private void checkEmptyAndThrowException(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
		}
	}

	private void checkCarNameListDuplicationAndThrowException(List<String> carNameList) {
		for (int i = 0; i < carNameList.size(); i++) {
			for (int j = i + 1; j < carNameList.size(); j++) {
				checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
			}
		}
	}

	private void checkEqualsAndThrowException(String carName1, String carName2) {
		if (carName1.equals(carName2)) {
			throw new IllegalArgumentException("[ERROR] 같은 이름을 가진 자동차가 있습니다.");
		}
	}

	private void checkLastIndexAndThrowException(String input) {
		if (input.lastIndexOf(",") == input.length() - 1) {
			throwMinLengthException();
		}
	}

	private void checkLengthAndThrowException(String carName) {
		if (CAR_NAME_RESTRICTIONS_MAX < carName.length()) {
			throwMaxLengthException();
		}
		if (carName.length() < CAR_NAME_RESTRICTIONS_MIN) {
			throwMinLengthException();
		}
	}

	private void throwMinLengthException() {
		throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_RESTRICTIONS_MIN + "글자 이상이어야 합니다.");
	}

	private void throwMaxLengthException() {
		throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_RESTRICTIONS_MAX + "글자 이하여야 합니다.");
	}

	private void checkSpaceAndThrowException(String carName) {
		if (carName.contains(SPACE)) {
			throwSpaceException();
		}
	}

	private void throwSpaceException() {
		throw new IllegalArgumentException("[ERROR] 자동차 이름안에는 공백이 있어서는 안됩니다.");
	}
}
