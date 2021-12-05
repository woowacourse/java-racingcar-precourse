package racingcar.domain;

public class Car {
	private static final int MOVE_NUM = 1;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		if (RandomMovementJudgment.checkCarMove()) {
			this.position = this.position + MOVE_NUM;
		}
	}
}
