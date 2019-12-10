package util;

import java.util.Random;

public class RandomNumberGenerator {

	private static Random random = new Random();

	static int NUMBER_BOUNDARY = 10;

	public static int generateNumber() {
		return random.nextInt(NUMBER_BOUNDARY);
	}
}
