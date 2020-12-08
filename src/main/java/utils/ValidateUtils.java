package utils;

import java.util.HashSet;

import racingcar.Message;

public class ValidateUtils {
	public static void checkCarNameLength(String[] carNameList) {
		for (String name : carNameList) {
			if (name.length() > 5) {
				throw new IllegalArgumentException(Message.nameLengthExceeded);
			}
		}
	}

	public static void checkNameSpace(String[] carNameList) {
		for (String name : carNameList) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException(Message.nameSpacesExistence);
			}
		}
	}

	public static void checkDuplicate(String[] carNameList) {
		HashSet<String> nameList = new HashSet<String>();

		for (String name : carNameList) {
			nameList.add(name);
		}

		if (nameList.size() != carNameList.length) {
			throw new IllegalArgumentException(Message.nameDuplication);
		}
	}

	public static void checkZeroCount(int number) {
		if (number == 0) {
			throw new IllegalArgumentException(Message.inputCountZero);
		}
	}
}
