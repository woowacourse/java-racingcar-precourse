package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class Validation {
	public static void LESS_MORE_NAME_ERROR(String [] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].length() > 5 || carNames[i].length() < 1) {
				throw new IllegalArgumentException(Constant.LESS_MORE_NAME_ERROR);
			}
		}
	}

	public static void CONTAIN_SAME_NAME_ERROR(String [] carNames){
		Set<String> tmpCarNamesSet = new HashSet<String>();

		for (int i = 0; i < carNames.length; i++){
			tmpCarNamesSet.add(carNames[i]);
		}

		if (tmpCarNamesSet.size() != carNames.length){
			throw new IllegalArgumentException(Constant.CONTAIN_SAME_NAME_ERROR);
		}
	}

	public static void WHITE_SPACE_NAME_ERROR(String [] carNames){
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].trim().isEmpty()) {
				throw new IllegalArgumentException(Constant.WHITE_SPACE_NAME_ERROR);
			}
		}
	}
}