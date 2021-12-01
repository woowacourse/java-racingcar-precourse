package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void go() {
		int num = Randoms.pickNumberInRange(0, 9);
		if (num >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
