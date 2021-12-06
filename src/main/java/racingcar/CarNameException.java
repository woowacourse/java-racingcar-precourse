package racingcar;

import java.util.HashSet;

public class CarNameException {
	private static final int LIMIT_SIZE = 5;
	private static final int NO_NAME = 0;

	private static final String LENGTH_ERROR_MESSAGE_1 = "[ERROR] 자동차 이름은 ";
	private static final String LENGTH_ERROR_MESSAGE_2 = "자 이하, 0자 이상만 가능하다.";
	private static final String REDUPLICATION_ERROR_MESSAGE = "[ERROR] 자동차 이름이 중복입니다.";
	private static final String SPACE_IN_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름에 공백은 불가합니다.";

	private String[] seperatedCarNames;
	private HashSet<String> carNameSet;

	public CarNameException(String[] seperatedCarNames) {
		this.seperatedCarNames = seperatedCarNames;
		carNameSet = new HashSet<String>();
	}

	public boolean canMakeCarsCompletely() {

		for (int i = 0; i < seperatedCarNames.length; i++) {

			if (!checkSizeException(seperatedCarNames[i]) || !checkReduplication(seperatedCarNames[i])) {
				return false;
			}

			if (!checkSpaceInName(seperatedCarNames[i]) || !checkTabInName(seperatedCarNames[i])) {
				return false;
			}

		}

		return true;
	}

	private boolean checkSizeException(String carName) {

		try {

			if (carName.length() > LIMIT_SIZE || carName.length() == NO_NAME) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(LENGTH_ERROR_MESSAGE_1 + LIMIT_SIZE + LENGTH_ERROR_MESSAGE_2);
			return false;
		}

		return true;
	}

	private boolean checkReduplication(String carName) {

		try {

			if (carNameSet.contains(carName)) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(REDUPLICATION_ERROR_MESSAGE);
			return false;
		}

		carNameSet.add(carName);
		return true;
	}

	private boolean checkSpaceInName(String carName) {
		String[] tmpArray = carName.split(" ", -1);

		try {

			if (tmpArray.length != 1) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(SPACE_IN_NAME_ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean checkTabInName(String carName) {
		String[] tmpArray = carName.split("\t", -1);

		try {

			if (tmpArray.length != 1) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(SPACE_IN_NAME_ERROR_MESSAGE);
			return false;
		}

		return true;
	}

}
