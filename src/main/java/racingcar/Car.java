package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public int move() {
		if (Randoms.pickNumberInRange(0, 10) >= 4) {
			this.position++;
		}
		return position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
