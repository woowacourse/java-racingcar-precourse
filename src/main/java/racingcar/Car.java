package racingcar;

import static racingcar.utils.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void playOnce() {
		move();
	}

	public void move() {
		if (checkMove(generateRandomNumber())) {
			position++;
		}
	}

	private int generateRandomNumber() {
		return Randoms.pickNumberInRange(RANGE_MIN_VALUE, RANGE_MAX_VALUE);
	}

	private boolean checkMove(int number) {
		return number >= 4;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
