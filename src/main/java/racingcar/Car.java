package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	static final int startNum = 0;
	static final int endNum = 9;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	int randomNumber() {
		int rand = Randoms.pickNumberInRange(startNum, endNum);
		return rand;
	}

	void positionMove(int n) {
		if (n >= 4) {
			this.position += 1;
		}

	}

	void visual() {
		System.out.print(this.name + " : ");
		for (int i = 0; i < this.position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	int getPosition() {
		return this.position;

	}

	String getName() {
		return this.name;

	}

}
