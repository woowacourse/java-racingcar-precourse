package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	public static final int CAR_NAME_MIN_LENGTH = 1;
	public static final int CAR_NAME_MAX_LENGTH = 5;
	public static final int MOVABLE_MIN = 4;
	public static final int MOVABLE_RANGE_MIN = 0;
	public static final int MOVABLE_RANGE_MAX = 9;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validName(name);
		this.name = name;
	}

	private void validName(String name) {
		if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 한다.");
		}
	}

	private void move() {
		if (movable()) {
			position += 1;
		}
	}

	private boolean movable() {
		return Randoms.pickNumberInRange(MOVABLE_RANGE_MIN, MOVABLE_RANGE_MAX) > MOVABLE_MIN;
	}
}
