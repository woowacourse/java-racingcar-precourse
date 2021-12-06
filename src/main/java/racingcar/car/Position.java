package racingcar.car;

class Position {
	private int position;

	Position() {
		this.position = 0;
	}

	private void next() {
		position++;
	}

	public int get() {
		return position;
	}

}
