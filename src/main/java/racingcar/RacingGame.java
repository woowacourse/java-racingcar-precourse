package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();
	private PlayerInput playerInput = new PlayerInput();

	public void runGame() {
		List<String> carNames = playerInput.getCarNames();
		makeCars(carNames);
		int moveCount = playerInput.getMoveTrialCount();
		moveCarsAndShowStatus(moveCount);
	}

	private void makeCars(List<String> carNames) {
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private void moveCarsAndShowStatus(int count) {
		System.out.println("\n실행 결과");
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < cars.size(); j++) {
				cars.get(j).goForwardByRandom();
				cars.get(j).printStatus();
			}
			System.out.println();
		}
	}
}
