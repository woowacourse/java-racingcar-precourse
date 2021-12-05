package racingcar.utils;

public class NameValidator {
	public static String validate(String name) {
		if (isHighLength(name))
			throw new IllegalArgumentException(Const.ERROR_INPUT_CAR_NAME_LENGTH);

		if (isEmptyOrBlank(name))
			throw new IllegalArgumentException(Const.ERROR_INPUT_CAR_NAME_EMPTY_OR_BLANK);

		return name;
	}

	private static boolean isHighLength(String name) {
		return name.length() > Const.MAX_NAME_COUNT;
	}

	private static boolean isEmptyOrBlank(String name) {
		return name.isEmpty() || name.trim().isEmpty();
	}
}
