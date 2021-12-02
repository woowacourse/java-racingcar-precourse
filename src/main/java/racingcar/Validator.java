package racingcar;

public class Validator {
	public static String validateName(String name) {
		if(name.length() > Const.MAX_NAME_COUNT)
			throw new IllegalArgumentException();
		return name;
	}

	public static int validateRound(String numStr) throws IllegalArgumentException {
		return Integer.parseInt(numStr);
	}
}
