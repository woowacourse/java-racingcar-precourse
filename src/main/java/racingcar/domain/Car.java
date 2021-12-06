package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MIN_POWER = 0;
	private static final int MAX_POWER = 9;
	private static final int THRESHOLD = 4;
	private static final int DISPLACEMENT = 1;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public List<String> move() {
		List<String> result = new ArrayList<>();
		if (canMove()) {
			position += DISPLACEMENT;
		}
		result.add(name);
		result.add(Integer.toString(position));
		return result;
	}

	private boolean canMove() {
		int randNum = Randoms.pickNumberInRange(MIN_POWER, MAX_POWER);
		return randNum >= THRESHOLD;
	}

	public int updateHighScore(int highScore) {
		return Math.max(position, highScore);
	}

	public void isChampion(List<String> champion, int highScore) {
		if (position == highScore) {
			champion.add(name);
		}
	}
}
