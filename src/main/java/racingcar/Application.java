package racingcar;

import static racingcar.utils.Input.*;
import static racingcar.utils.Output.*;

import racingcar.domain.Car;

public class Application {
	public static void main(String[] args) {

		String[] carNames = inputCarNames();
		Car[] cars = inputCarNameToCarObj(carNames);

		int coin = inputCoinNumber();

		while (coin-- > 0) {
			inputRandomNumberToCar(cars);
			outputCarPosition(cars);
		}

		outputRaceResult(cars);
	}

}

