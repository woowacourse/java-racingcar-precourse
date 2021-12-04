package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<String> carNames = new ArrayList<>();
	private List<Car> cars = new ArrayList<>();
	private int moveCount = 0;
	private PlayerInput playerInput = new PlayerInput();

	public void runGame() {
		while (carNames.isEmpty()){
			setCarNamesFromInput();
		}
		makeCars(carNames);
		while (moveCount == 0){
			setMoveCountFromInput();
		}
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

	private void setCarNamesFromInput() {
		try {
			carNames = playerInput.getCarNames();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void setMoveCountFromInput() {
		try {
			moveCount = playerInput.getMoveTrialCount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
