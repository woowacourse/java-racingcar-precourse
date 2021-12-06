package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public String[] getNames() {

		while (true) {
			String[] names = Console.readLine().split("-");
			for (String name : names) {
				if (!isValidateName(name)) {
					throw new IllegalArgumentException();
				}
			}
			return names;
		}
	}

	public boolean isValidateName(String name) {

		if (name.length() > 5) {
			return false;
		}

		if (name.length() == 0) {
			return false;
		}

		return true;
	}

	public Integer getGameNumber() {
		while (true) {
			String gameNumber = Console.readLine();
			if (!isNumeric(gameNumber)) {
				throw new IllegalArgumentException();
			}
			return Integer.parseInt(gameNumber);
		}
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
