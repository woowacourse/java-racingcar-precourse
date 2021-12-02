package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void advance() {
		int randNum = Randoms.pickNumberInRange(0, 9);
		if (randNum > 3) {
			this.position++;
		}
	}
}
