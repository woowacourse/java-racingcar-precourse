package racingcar;

import racingcar.utils.RandomGenerator;
import racingcar.utils.Constant;

public class Car {
	private final String driverName;
	private int position = 0;

	public Car(String driverName) {
		this.driverName = driverName;
	}

	public void playTurn(){
		RandomGenerator randomGenerator = new RandomGenerator();
		if (randomGenerator.getRandomNum() >= Constant.MOVE_VALUE) {
			this.position++;
		}
	}

	public void printPosition(){
		System.out.print(this.driverName + " : ");
		for(int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
