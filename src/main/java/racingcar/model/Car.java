package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Car {

	private final String name;
	private int position = 0;

	private static final int MINIMUM_RANDOM_RANGE = 0;
	private static final int MAXIMUM_RANDOM_RANGE = 9;
	private static final int MOVE_CONDITION_NUMBER = 4;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public int makeRandomNumber() {
		return Randoms.pickNumberInRange(MINIMUM_RANDOM_RANGE, MAXIMUM_RANDOM_RANGE);
	}

	public boolean checkMoveForward() {
		int randomNumber = makeRandomNumber();
		return randomNumber >= MOVE_CONDITION_NUMBER;
	}

	public int currentPosition() {
		if (checkMoveForward()) {
			position++;
		}
		return position;
	}

	public void printCarPosition() {
		position = currentPosition();
		OutputView.printCarNameAndColon(name);
		OutputView.printPosition(position);
	}
}
