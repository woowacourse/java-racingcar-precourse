package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;
	private static int maxPosition = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void moveForward() {
		position++;
	}

	public void printPosition() {

		StringBuilder road = new StringBuilder();
		for (int i = 0; i < position; i++) {
			road.append("-");
		}
		System.out.println(name + " : " + road);
	}

	public void moveOrStop() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			moveForward();
			updateMaxPosition();
		}
	}

	private void updateMaxPosition() {
		if (position > maxPosition) {
			maxPosition = position;
		}
	}

	public boolean isWinner() {
		return (maxPosition == position);
	}
}
