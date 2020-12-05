package utils;

public class Converter {
	private static final char MOVEMENT_CHARACTER = '-';

	private static final StringBuilder stringBuilder = new StringBuilder();

	public static String convertToPosition(int position) {
		stringBuilder.delete(0, stringBuilder.length());

		for (int number = 0; number < position; number += 1) {
			stringBuilder.append(MOVEMENT_CHARACTER);
		}

		return stringBuilder.toString();
	}
}
