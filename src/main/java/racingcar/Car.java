package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void move(int randomNum) {
		if (canMove(randomNum)) {
			position++;
		}
	}

	private boolean canMove(int randomNum) {
		return randomNum >= 4;
	}

	protected boolean isMoved() {
		return position != 0;
	}
}
