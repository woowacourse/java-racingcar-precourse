package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void GoOrStay() {
		int randomNum = Randoms.pickNumberInRange(0, 9);

		if (randomNum >= 4) {
			position++;
		}
	}

	// 추가 기능 구현
}
