package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int RANDOM_MIN_NUMBER = 0;
	private static final int RANDOM_MAX_NUMBER = 9;
	private static final int STANDARD = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void moveOrStop() {
		if (canGo()) {
			position++;
		}
	}

	private boolean canGo() {
		if (Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER) >= STANDARD) {
			return true;
		}
		return false;
	}
}
