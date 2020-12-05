package utils;

import java.util.Arrays;
import java.util.HashSet;

public class CarNameInputValidator {
	private static final Integer MAX_CARNAME_LENGTH = 5;

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
