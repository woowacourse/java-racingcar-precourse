package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int currentPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void moveAhead() {
		++position;
	}

	public void printCurrentPosition() {
		System.out.printf("%s : %s\n", name, visualizePosition());
	}

	public boolean isWinner(int maxPosition) {
		return position == maxPosition;
	}

	private String visualizePosition() {
		StringBuilder builder = new StringBuilder();
		for (int locate = 0; locate < position; ++locate) {
			builder.append("-");
		}
		return builder.toString();
	}
}
