package racingcar;

/*
 * 값이 유효한지 검사하는 클래스
 * */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	private static final int CAR_NAME_MIN = 1;
	private static final int CAR_NAME_MAX = 5;
	private static final int CAR_TRIALS_NUM = 1;

	public static void validateCarNames(String[] carNames) {
		validateCarNameOverlap(carNames);

		for (String carName : carNames) {
			validateCarNameFormat(carName);
			validateCarNameLength(carName);
		}
	}

	public static void validateCarNameLength(String carName) {
		if (carName.length() < CAR_NAME_MIN) {
			throw new IllegalArgumentException("[ERROR] 최소 1글자 입니다.");
		}

		if (carName.length() > CAR_NAME_MAX) {
			throw new IllegalArgumentException("[ERROR] 최대 5글자 입니다.");
		}
	}

	public static void validateCarNameFormat(String carName) {
		if (carName.contains(" ")) {
			throw new IllegalArgumentException("[ERROR] 공백은 포함될 수 없습니다.");
		}
	}

	public static void validateCarNameOverlap(String[] carNames) {
		List<String> carNameList = Arrays.asList(carNames);
		Set<String> carNameSet = new HashSet<>(carNameList);
		if (carNameSet.size() != carNameList.size()) {
			throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
		}
	}

	public static void validateRoundNum(String input) {
		int trialNum = validateRoundNumFormat(input);
		validateRoundNumRange(trialNum);
	}

	public static int validateRoundNumFormat(String input) { // 숫가자 아닌게 들어오는 지 확인
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
		}
	}

	public static void validateRoundNumRange(int trialNum) {
		if (trialNum < CAR_TRIALS_NUM) {
			throw new IllegalArgumentException("[ERROR] 최소 1 이상 입니다.");
		}
	}

}
