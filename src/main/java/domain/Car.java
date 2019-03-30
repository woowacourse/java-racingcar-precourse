package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		int random = setRandom();
		if (random < 4) {
			return;
		}
		position++;
	}

	public int setRandom() {
		return (int)(Math.random() * 9);
	}

	public void printPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
