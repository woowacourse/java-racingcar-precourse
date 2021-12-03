package racingcar;

import racingcar.utils.RandomGenerator;
import racingcar.utils.Constant;

public class Car {
	private final String carName;
	private int position = 0;

	public Car(String carName) {
		this.carName = carName;
	}

	public void playTurn(){
		RandomGenerator randomGenerator = new RandomGenerator();
		if (randomGenerator.getRandomNum() >= Constant.MOVE_VALUE) {
			this.position++;
		}
	}

	public void printPosition(){
		System.out.print(this.carName + " : ");
		for(int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public String getCarName(){
		return this.carName;
	}
	public int getPosition(){
		return this.position;
	}
}
