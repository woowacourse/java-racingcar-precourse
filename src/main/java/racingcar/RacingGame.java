package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
	private final List<Car> cars;

	public RacingGame(String[] carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void moveCars() {
		for (Car car : cars) {
			car.movdOrStop();
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
