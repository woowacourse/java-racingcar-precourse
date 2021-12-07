package racingcar.model;

import racingcar.utils.RandomForward;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void forward(RandomForward randomForward) {
		if (randomForward.isForward()) {
			this.position++;
		}
		return;
	}

	public void printPosition() {
		System.out.print(this.name + " : ");
		for (int count = 0; count < this.position; count++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
