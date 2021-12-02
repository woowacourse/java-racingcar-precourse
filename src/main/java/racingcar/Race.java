package racingcar;

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

	}

	private void toCar(List<String> carNames) {
		carNames.forEach(carName -> cars.add(new Car(carName)));
	}
}
