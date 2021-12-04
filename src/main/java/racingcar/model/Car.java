package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String NAME;
	private int position = 0;

	public Car(String name) {
		this.NAME = name;
	}

	public void go() {
		if (getRandomNum() >= Constants.GO_NUM) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(int winDistance) {
		return position == winDistance;
	}

	public String getName() {
		return NAME;
	}

	private int getRandomNum() {
		return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
	}
}
