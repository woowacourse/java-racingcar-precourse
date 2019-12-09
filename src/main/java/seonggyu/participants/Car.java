package seonggyu.participants;

import java.util.Random;

public class Car {
	private static final int RAND_NUM_RANGE = 10;
	private static final int THRESHOLD = 3;

	private final String name;
	private int position = 0;

	public Car(String inputName) {
		CarConstraints.checkValidCarName(inputName);
		this.name = inputName;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void goOrStay() {
		if (makeRandomNumber() > THRESHOLD) {
			this.position++;
		}
	}
	
	private int makeRandomNumber() {
		Random RANDOM = new Random();
		return RANDOM.nextInt(RAND_NUM_RANGE);
	}

	public void printNameAndPosition() {
		StringBuilder nameAndPosition = new StringBuilder();

		nameAndPosition.append(this.name + " : ");
		for (int i = 0; i < this.position; i++) {
			nameAndPosition.append("-");
		}
		System.out.println(nameAndPosition);
	}

	public boolean isWinnerCandidate(int maxDistance) {
		if (this.position >= maxDistance) {
			return true;
		}
		return false;
	}
}
