package racingcar;

import utils.RandomUtils;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void increase_position() {
		this.position++;
	}

	public void move_or_stop() {
		if (RandomUtils.nextInt(0, 9) >= 4) {
			increase_position();
		}
	}

	public void print_position() {
		System.out.println(name+" : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
