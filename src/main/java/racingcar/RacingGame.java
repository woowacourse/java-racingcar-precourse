package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();
	private PlayerInput playerInput = new PlayerInput();

	public void runGame() {
		List<String> carNames = playerInput.getCarNames();
		makeCars(carNames);
	}

	private void makeCars(List<String> carNames) {
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}
}
