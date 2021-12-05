package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class Race {
	private static final List<Car> cars = new ArrayList<>();
	private final int attemptNumber;

	public Race(String[] carNameArray, int attemptNumber) {
		generateCars(carNameArray);
		this.attemptNumber = attemptNumber;

	}

	private void generateCars(String[] carNameArray) {
		for (String name : carNameArray) {
			Car car = new Car(name);
			cars.add(car);
		}
	}

	public void start() {
		for (int i = 0; i < attemptNumber; i++) {
			cars.stream()
				.peek(car -> car.move(RandomNumberGenerator.generate()))
				.forEach(OutputView::printMoveResult);
			System.out.println();
		}
	}

	public List<Car> findWinner() {
		List<Car> winners = new ArrayList<>();
		cars.sort(Collections.reverseOrder());
		int maxPosition = cars.get(0).getPosition();
		for (Car car : cars) {
			if (maxPosition > car.getPosition()) {
				return winners;
			}
			winners.add(car);
		}
		return winners;
	}
}
