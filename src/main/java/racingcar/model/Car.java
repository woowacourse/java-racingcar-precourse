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
	private int makeRandomNumber() {
		return Randoms.pickNumberInRange(MINIMUM_RANDOM_RANGE, MAXIMUM_RANDOM_RANGE);
	}

	private boolean checkMoveForward() {
		int randomNumber;

		randomNumber = makeRandomNumber();
		return randomNumber >= MOVE_CONDITION_NUMBER;
	}

	private void movePosition() {
		if (checkMoveForward()) {
			position++;
		}
	}

	public void getMovedPosition() {
		movePosition();
		OutputView.printCarNameAndColon(name);
		OutputView.printPosition(position);
	}

	public int getCurrentPosition() {
		return position;
	}

	public String getWinnerName(int firstPosition) {
		if (position == firstPosition) {
			return name;
		}
		return null;
	}
}
