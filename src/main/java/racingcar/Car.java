package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println(name);
	}

	public void printCarPosition() { // printPosition
		String name = String.format("%s : ", this.name);
		String distance = new String(new char[position]).replace("\0", "-");

		System.out.println(name + distance);
	}

	private int getMovement() {
		int result = Randoms.pickNumberInRange(0, 9);
		if (result >= 4) {
			return 1;
		}

		return 0;
	}

	public int move() {
		int movement = getMovement();
		this.position += movement;
		printCarPosition();
		return movement;
	}

}
