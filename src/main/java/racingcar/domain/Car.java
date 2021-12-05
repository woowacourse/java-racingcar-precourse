package racingcar.domain;

import static racingcar.constants.GameConstants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void tryMoving() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			move();
		}
	}

	public String getDashedPosition() {
		StringBuilder dashedPosition = new StringBuilder();
		for (int i = 0; i < position; i++) {
			dashedPosition.append(MOVING_GAUGE);
		}
		return dashedPosition.toString();
	}

	private void move() {
		position += 1;
	}
}
