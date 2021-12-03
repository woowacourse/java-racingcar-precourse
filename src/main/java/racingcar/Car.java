package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveForward() {
		if (isMoveSuccess()) {
			position++;
		}
	}

	public boolean isMoveSuccess() {
		return Randoms.pickNumberInRange(GameData.START_NUMBER, GameData.END_NUMBER) >= GameData.CRITERIA_NUMBER;
	}
}
