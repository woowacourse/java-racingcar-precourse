package racingcar.model;

import static racingcar.Util.getMax;

import java.util.ArrayList;
import java.util.stream.Collectors;

import racingcar.view.OutputView;

public class RacingCars {
	private final ArrayList<Car> CARS = new ArrayList<>();

	public RacingCars(ArrayList<String> cars) {
		cars.forEach(car -> CARS.add(new Car(car)));
	}

	public void playRound() {
		go();
		OutputView.printRoundResult(new ArrayList<>(CARS.stream()
			.map(Car::getRoundResult)
			.collect(Collectors.toList())
		));
	}

	public void showWinners() {
		OutputView.printWinner(new ArrayList<>(CARS.stream()
			.filter(car -> car.isWinner(getMax(getPositions())))
			.map(Car::getName)
			.collect(Collectors.toList())
		));
	}

	private void go() {
		CARS.forEach(Car::go);
	}

	private ArrayList<Integer> getPositions() {
		ArrayList<Integer> positions = new ArrayList<>();
		CARS.forEach(car -> positions.add(car.getPosition()));
		return positions;
	}
}
