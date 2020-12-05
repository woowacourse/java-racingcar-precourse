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
	
	public int get_position() {
		return this.position;
	}
	
	public String get_name(){
		return this.name;
	}
	public void move_or_stop() {
		if (RandomUtils.nextInt(0, 9) >= 4) {
			increase_position();
		}
	}

	public void print_position() {
		System.out.print(name+" : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
