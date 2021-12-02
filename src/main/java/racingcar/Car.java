package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void tryMoving() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			move();
		}
	}

	private void move() {
		position += 1;
	}
}
