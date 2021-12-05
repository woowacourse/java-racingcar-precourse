package racingcar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RacingGame {
	private static final int ONLY_ONE_WINNER = 1;

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

	private Queue<String> findWinners() {
		int winnerPosition = getWinnerPositionFromCars();
		Queue<String> winnersName = new LinkedList<>();
		for (Car car : cars) {
			if (car.getPosition() == winnerPosition) {
				winnersName.add(car.getName());
			}
		}
		return winnersName;
	}

	private int getWinnerPositionFromCars() {
		int winnerPosition = 0;
		for (Car car : cars) {
			if (winnerPosition <= car.getPosition()){
				winnerPosition = car.getPosition();
			}
		}
		return winnerPosition;
	}
}
