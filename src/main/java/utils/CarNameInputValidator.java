package utils;

import java.util.Arrays;
import java.util.HashSet;

public class CarNameInputValidator {
	private static final Integer MAX_CARNAME_LENGTH = 5;
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String NULL_ERROR_MESSAGE = "자동차 이름은 1자 이상이여야 합니다.";
	private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하이여야 합니다.";
	private static final String UNIQUE_ERROR_MESSAGE = "자동차 이름은 중복되면 안 됩니다.";

	public static void inputVaildCheck(String[] names) {
		for (String name : names) {
			if (isNull(name)) {
				throw new IllegalArgumentException(ERROR_PREFIX + NULL_ERROR_MESSAGE);
			}
		}

		for (String name : names) {
			if (!isRightLength(name)) {
				throw new IllegalArgumentException(ERROR_PREFIX + LENGTH_ERROR_MESSAGE);
			}
		}

		if (!isAllUniqueName(names)) {
			throw new IllegalArgumentException(ERROR_PREFIX + UNIQUE_ERROR_MESSAGE);
		}
	}

	public static boolean isNull(String name) {
		if (name == null || name.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isRightLength(String name) {
		if (name.length() <= MAX_CARNAME_LENGTH) {
			return true;
		}
		return false;
	}

	public static boolean isAllUniqueName(String[] names) {
		HashSet<String> uniqueNames = new HashSet<String>(Arrays.asList(names));
		if (uniqueNames.size() == names.length) {
			return true;
		}
		return false;
	}
}
