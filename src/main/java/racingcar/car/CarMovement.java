package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement {
	private static final int MIN_RANGE = 0;
	private static final int MAX_RANGE = 9;
	private static final int FORWARD_STANDARD = 4;

	private int randomNumber;

	public boolean isMoveForward() {
		generateRandomNumber();
		if (randomNumber >= FORWARD_STANDARD) {
			return true;
		}
		return false;
	}

	private void generateRandomNumber() {
		randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
	}
}
