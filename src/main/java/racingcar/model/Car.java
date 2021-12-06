package racingcar.model;

import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomNumberStrategy;

public class Car {
	private final String name;
	private int position = 0;

	MoveStrategy moveStrategy = new RandomNumberStrategy();

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void move() {
		this.position++;
	}

	public void playRound() {
		if (moveStrategy.isMoveable()) {
			this.move();
		}
	}
}
