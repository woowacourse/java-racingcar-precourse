package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

public class Car {
	private final String NAME;
	private int position = 0;

	public Car(String name) {
		this.NAME = name;
	}

	public void go() {
		if (Util.getRandomNum() >= Constants.GO_NUM) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public boolean isWinner(int winDistance) {
		return position == winDistance;
	}

	public String getRoundResult() {
		return NAME + Constants.ROUND_RESULT_DELIMITER + Util.dashRepeat(position);
	}

	public String getName() {
		return NAME;
	}
}
