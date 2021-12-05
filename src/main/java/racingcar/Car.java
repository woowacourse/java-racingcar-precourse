package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final int START_NUMBER_OF_RANGE = 0;
	private final int END_NUMBER_OF_RANGE = 9;
	private final int STANDARD_NUMBER_OF_GO = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void goOrStop() {
		int randomNumber = Randoms.pickNumberInRange(START_NUMBER_OF_RANGE, END_NUMBER_OF_RANGE);
		if (randomNumber >= STANDARD_NUMBER_OF_GO) {
			position++;
		}
	}
}
