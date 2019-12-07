package util;

import java.util.Random;

public class RandomNumber {
	private static final int BOUND = 10;
	private static final Random GENERATOR = new Random();

	public static int pick() {
		return GENERATOR.nextInt(BOUND);
	}
}
