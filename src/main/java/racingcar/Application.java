package racingcar;

import static racingcar.Input.*;
import static racingcar.Output.*;
import static racingcar.RandomNumberBox.*;

public class Application {
	public static void main(String[] args) {

		String[] carNames = inputCarNames();
		Car[] cars = inputCarNameToCarObj(carNames);

		int coin = inputCoinNumber();
		while (coin-- > 0) {
			for (Car car : cars) {
				car.moveOrStop(getRandomNumber());
			}
			outputCarPosition(cars);
		}
		outputRaceResult(cars);
	}
}

