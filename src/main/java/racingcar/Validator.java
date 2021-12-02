package racingcar;

public class Validator {
	public static void validateName(String name) {
		if(name.length() > Const.MAX_NAME_COUNT)
			throw new IllegalArgumentException();
	}

	public static int validateRound(String numStr) throws IllegalArgumentException {
		return Integer.parseInt(numStr);
	}
}
