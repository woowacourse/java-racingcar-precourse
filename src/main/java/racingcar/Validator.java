package racingcar;

public class Validator {
	public static String validateName(String name) {
		if(isHighLength(name))
			throw new IllegalArgumentException();

		if(isEmptyOrBlank(name))
			throw new IllegalArgumentException();

		return name;
	}

	public static int validateRound(String numStr) throws IllegalArgumentException {
		return Integer.parseInt(numStr);
	}

	private static boolean isHighLength(String name) {
		return name.length() > Const.MAX_NAME_COUNT;
	}

	private static boolean isEmptyOrBlank(String name) {
		return name.isEmpty() || name.trim().isEmpty();
	}
}
