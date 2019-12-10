package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void tryToMove(int energy) {
		if (energy >= 4) {
			position++;
		}
	}

	public void printPosition() {
		String msg = name + ": ";
		for (int i = 0; i < position; i++) {
			msg += "-";
		}
		System.out.println(msg);
	}

	public int getResult() {
		return position;
	}
}
