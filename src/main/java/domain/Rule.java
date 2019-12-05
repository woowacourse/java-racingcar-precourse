package domain;

import java.util.Random;

public class Rule {
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_BOUND = 10;
	private static final int GO_BOUNDARY_NUMBER = 4;

	public static boolean isGo() {
		int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
		return randomNumber >= GO_BOUNDARY_NUMBER;
	}
}
