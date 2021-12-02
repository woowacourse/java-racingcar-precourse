package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int CRITERION = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void tryToMove() {
		if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= CRITERION) {
			position++;
		}
	}

	public void printPosition() {
		StringBuilder strPosition = new StringBuilder();
		for (int i = 0; i < position; i++) {
			strPosition.append("-");
		}
		System.out.printf("%s : %s%n", name, strPosition);
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}
}
