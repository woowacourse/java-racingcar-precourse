package racingcar.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameException {

	private static final String CAR_NUMBER_IS_ONE_ERROR_MASSAGE = "[ERROR] 하나의 자동차로는 게임을 진행할 수 없습니다! 다시 입력해주세요.";
	private static final String NAME_DUPLICATION_ERROR_MASSAGE = "[ERROR] 중복된 이름이 있어, 게임을 진행할 수 없습니다! 다시 입력해주세요.";
	private static final String NAME_LENGTH_OVER_ERROR_MASSAGE = "[ERROR] 자동차의 이름은 5자 이하만 가능합니다! 다시 입력해주세요.";
	private static final String NAME_EMPTY_ERROR_MASSAGE = "[ERROR] 자동차의 이름이 공백일 수 없습니다! 다시 입력해주세요.";
	private static final String STRING_EMPTY_ERROR_MASSAGE = "[ERROR] 자동차의 이름이 빈칸입니다! 다시 입력해주세요.";
	private static final int NAME_MAX_LENGTH = 5;
	private static final int CAR_LIST_MIN_SIZE = 1;

	public static void checkCarNameException(String[] carNameList) {
		for (String carName : carNameList) {
			checkEmptyString(carName);
			checkEmptyName(carName);
			checkNameOverLength(carName);
		}
		checkCarNumberIsOne(carNameList);
		checkNameDuplication(carNameList);
	}

	public static void checkEmptyString(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException(STRING_EMPTY_ERROR_MASSAGE);
		}
	}

	private static void checkEmptyName(String carName) {
		if (carName.trim().isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR_MASSAGE);
		}
	}

	private static void checkNameOverLength(String carName) {
		if (carName.length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_OVER_ERROR_MASSAGE);
		}
	}

	private static void checkNameDuplication(String[] carName) {
		Set<String> carsSet = new HashSet<>(Arrays.asList(carName));
		if (carName.length != carsSet.size()) {
			throw new IllegalArgumentException(NAME_DUPLICATION_ERROR_MASSAGE);
		}
	}

	private static void checkCarNumberIsOne(String[] carsList) {
		if (carsList.length == CAR_LIST_MIN_SIZE) {
			throw new IllegalArgumentException(CAR_NUMBER_IS_ONE_ERROR_MASSAGE);
		}
	}
}
