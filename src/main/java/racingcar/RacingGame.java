package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private final List<Car> cars;

	public RacingGame(String[] carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}
}
