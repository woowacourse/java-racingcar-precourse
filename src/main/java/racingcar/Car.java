package racingcar;

import racingcar.utils.RandomGenerator;
import racingcar.view.OutputView;

import static racingcar.utils.ConstantNum.*;

public class Car {
	private final String carName;
	private int position = 0;

	public Car(String carName) {
		this.carName = carName;
	}

	public void proceedOrPause() {
		RandomGenerator randomGenerator = new RandomGenerator();
		if (randomGenerator.getRandomNum() >= PROCEED_NUM_MIN) {
			this.position++;
		}
	}

	public void printPosition(){
		OutputView.printPosition(carName, position);
	}
}