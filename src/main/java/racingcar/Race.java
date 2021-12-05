package racingcar;

import static utils.Message.*;
import static utils.Random.*;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private final List<Car> cars;
	private final int attemptNumber;

	public Race(List<String> carNames, int attemptNumber) {
		cars = new ArrayList<>();
		toCar(carNames);
		this.attemptNumber = attemptNumber;
	}

	public void run() {
		start();
		result(cars);
	}

	private void toCar(List<String> carNames) {
		carNames.forEach(carName -> cars.add(new Car(carName)));
	}

	private void start() {
		System.out.println(EXECUTION_RESULT_MESSAGE);

		for (int attempt = 0; attempt < attemptNumber; attempt++) {
			racingCar();
		}
	}

	private void racingCar() {
		cars.forEach(car -> {
			checkForwardCondition(car);
			System.out.println(car.toString());
		});

		System.out.println();
	}

	private void checkForwardCondition(Car car) {
		int randomNumber = generateRandomNumber();

		if (randomNumber >= FORWARD_CONDITION_NUMBER) {
			car.forward();
		}
	}

	private void result(List<Car> cars) {
		Winner winner = new Winner();
		winner.decide(cars);
	}
}
