package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public String[] getNames() {
		String[] names = Console.readLine().split(",");
		for (String name : names) {
			if (!isValidateName(name)) {
				throw new IllegalArgumentException(Constant.NAME_ERROR_MESSAGE);
			}

		}
		return names;
	}

	public boolean isValidateName(String name) {
		if (name.length() > Constant.MAXIMUM_NAME_NUMBER) {
			return false;
		}
		return name.length() != Constant.INVALID_NAME_LENGTH;
	}

	public Integer getGameNumber() {
		String gameNumber = Console.readLine();
		if (!isNumeric(gameNumber)) {
			throw new IllegalArgumentException(Constant.NUMBER_ERROR_MESSAGE);
		}
		return Integer.parseInt(gameNumber);
	}

	public boolean isNumeric(String gameNumber) {
		for (int i = 0; i < gameNumber.length(); i++) {
			if (!Character.isDigit(gameNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
