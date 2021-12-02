package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void move() {
		if (canMove()) {
			position++;
		}
	}

	private boolean canMove() {
		return Randoms.pickNumberInRange(1, 10) >= 4;
	}

	protected boolean isMoved() {
		return position != 0;
	}
}
