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

	public int getPosition() {
		return position;
	}

	public void tryToMove(int energy) {
		if (energy >= 4) {
			position++;
		}
	}

	public void printPosition() {
		String gageBar = "";

		for (int i = 0; i < position; i++) {
			gageBar += "-";
		}
		System.out.println(name + ": " + gageBar);
	}
}
