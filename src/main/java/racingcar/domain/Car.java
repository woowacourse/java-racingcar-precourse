package racingcar.domain;

public class Car {
import racingcar.util.Constant;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public String getPositionAsString() {
		StringBuilder moveResult = new StringBuilder();
		for (int i = 0; i < position; i++) {
			moveResult.append(Constant.MOVE_MARK);
		}
		return moveResult.toString();
	}

	public void move(int randomNumber) {
		System.out.println(randomNumber);
		if (randomNumber >= Constant.MOVE_MIN_VALUE) {
			position++;
		}
	}
}
