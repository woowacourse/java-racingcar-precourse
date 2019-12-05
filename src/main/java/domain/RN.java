package domain;

import java.util.Random;

public class RN {
	int makeRandom() {
		Random rand = new Random();
		return rand.nextInt(10);
	}
}
