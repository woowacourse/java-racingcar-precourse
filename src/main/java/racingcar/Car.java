package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void printCarPosition() {
		String name = String.format("%s : ", this.name);
		String distance = new String(new char[position]).replace("\0", "-");

		System.out.println(name + distance);
	}

	private boolean flipCoin() {
		int result = Randoms.pickNumberInRange(0, 9);
		return result >= 4;
	}

	public void move() {
		if (flipCoin()) {
			this.position += 1;
		}

		printCarPosition();
	}

}
