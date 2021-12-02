package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
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
		return name;
	}

	private int getRandomNum() {
		return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
	}
}
