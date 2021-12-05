package model;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getCarName() {
		return this.name;
	}

	public int getCarPosition() {
		return this.position;
	}

	public void forwardCar() {
		this.position += 1;
	}

	public boolean isWinner(int maxPosition) {
		return this.position == maxPosition;
	}
}
