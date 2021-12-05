package racingcar.game.model;

import java.util.HashMap;
import java.util.Map;

public class Power {
	private static final Map<Integer, Power> map = new HashMap<>();
	private static final int MIN_BOUND = 4;
	private final int randomNumber;

	public Power(final int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public static Power valueOf(final int randomNumber) {
		if (map.containsKey(randomNumber)) {
			return map.get(randomNumber);
		}

		Power newPower = new Power(randomNumber);
		map.put(randomNumber, newPower);
		return newPower;
	}

	public boolean isMovable() {
		return randomNumber >= MIN_BOUND;
	}

}
