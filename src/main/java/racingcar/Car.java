package racingcar;

import utils.RandomUtils;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 異붽� 湲곕뒫 援ы쁽

	public void statusPrint() {
		String range = "";
		for (int i = 0; i < position; i++) {
			range += "-";
		}
		System.out.println(name + " : " + range);
	}

	public void move() {
		if (RandomUtils.nextInt(0, 9) >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
