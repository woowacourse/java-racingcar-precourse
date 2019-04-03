package domain;

public class Car {
	private final static int ONE_SPACE = 1;
	private final static int MULTIPLES_FOR_DIGIT = 10;
	private final static int STANDARD_NUMBER_OF_MOVING = 3;
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
	
	public void race() {
		if (canMove()) {
			moveForward();
		}
	}

	private boolean canMove() {
		return (int) (Math.random() * MULTIPLES_FOR_DIGIT) > STANDARD_NUMBER_OF_MOVING;
	}

	private void moveForward() {
		this.position += ONE_SPACE;
	}
}
