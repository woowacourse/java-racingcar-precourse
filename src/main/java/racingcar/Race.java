package racingcar;

import static utils.Message.*;
import static utils.Random.*;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private List<Car> cars = new ArrayList<>();
	private int attemptNumber;

	public Race(List<String> carNames, int attemptNumber) {
		toCar(carNames);
		this.attemptNumber = attemptNumber;
	}

	public void start() {
		System.out.println(EXECUTION_RESULT_MESSAGE);

		for (int attempt = 0; attempt < attemptNumber; attempt++) {
			racingCar();
		}

	}

	private void toCar(List<String> carNames) {
		carNames.forEach(carName -> cars.add(new Car(carName)));
	}

	private void racingCar() {
		cars.forEach(car -> {
			if (checkForwardCondition()) {
				car.forward();
			}

			System.out.println(car.toString());
		});

		System.out.println();
	}
}
