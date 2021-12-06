package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

import static racingcar.utils.Constant.*;

public class Validation {
	public static void LESS_MORE_NAME_ERROR(String[] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].length() > CAR_NAME_LENGTH_MAX || carNames[i].length() < CAR_NAME_LENGTH_MIN) {
				throw new IllegalArgumentException(Constant.LESS_MORE_NAME_ERROR);
			}
		}
	}

	public static void CONTAIN_SAME_NAME_ERROR(String[] carNames) {
		Set<String> tmpCarNamesSet = new HashSet<String>();

		for (int i = 0; i < carNames.length; i++) {
			tmpCarNamesSet.add(carNames[i]);
		}

		if (tmpCarNamesSet.size() != carNames.length) {
			throw new IllegalArgumentException(Constant.CONTAIN_SAME_NAME_ERROR);
		}
	}

	public static void WHITE_SPACE_NAME_ERROR(String[] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].trim().isEmpty()) {
				throw new IllegalArgumentException(Constant.WHITE_SPACE_NAME_ERROR);
			}
		}
	}

	public static void NON_NUMERIC_GAME_COUNT_ERROR(String stringGameCount) {
		for (int i = 0; i < stringGameCount.length(); i++) {
			if (stringGameCount.charAt(i) < STRING_GAME_COUNT_MIN || STRING_GAME_COUNT_MAX < stringGameCount.charAt(i)) {
				throw new NumberFormatException(Constant.NON_NUMERIC_GAME_COUNT_ERROR);
			}
		}
	}

	public static void ZERO_GAME_COUNT_ERROR(String stringGameCount) {
		if (stringGameCount.equals(STRING_GAME_COUNT_MIN)) {
			throw new NumberFormatException(Constant.ZERO_GAME_COUNT_ERROR);
		}
	}
}