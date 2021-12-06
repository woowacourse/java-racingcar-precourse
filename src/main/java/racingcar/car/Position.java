package racingcar.car;

public class Position {
	private int position;

	Position() {
		this.position = 0;
	}

	private void next() {
		position++;
	}

	private int get() {
		return position;
	}
}
