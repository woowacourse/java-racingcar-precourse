package racingcar.model;

import java.util.ArrayList;

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

	public ArrayList<String> move() {
		ArrayList<String> result = new ArrayList<>();
		if (Randoms.pickNumberInRange(MIN_POWER, MAX_POWER) >= THRESHOLD) {
			position += DISPLACEMENT;
		}
		result.add(name);
		result.add(Integer.toString(position));
		return result;
	}

	public int updateHighScore(int highScore) {
		return Math.max(position, highScore);
	}

	public void isChampion(ArrayList<String> champion, int highScore) {
		if (position == highScore) {
			champion.add(name);
		}
	}
}
