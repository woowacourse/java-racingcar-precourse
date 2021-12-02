package racingcar;

import static utils.Message.*;
import static utils.Random.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

	private List<Car> cars = new ArrayList<>();
	private int attemptNumber;

	public Race(List<String> carNames, int attemptNumber) {
		toCar(carNames);
		this.attemptNumber = attemptNumber;
	}

	public void start() {
		System.out.println(EXECUTION_RESULT_MESSAGE);

		for (int attempt = 0; attempt < attemptNumber; attempt++) {
			racingCar();
		}

		pickWinner();
	}

	private void toCar(List<String> carNames) {
		carNames.forEach(carName -> cars.add(new Car(carName)));
	}

	private void racingCar() {
		cars.forEach(car -> {
			if (checkForwardCondition()) {
				car.forward();
			}

			System.out.println(car.toString());
		});

		System.out.println();
	}

	private void pickWinner() {
		int firstPosition = calculateFirstPosition();

		List<String> raceWinner = cars.stream()
			.filter(car -> car.getPosition() == firstPosition)
			.map(Car::getName)
			.collect(Collectors.toList());

		printRaceWinner(raceWinner);
	}

	private int calculateFirstPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	private void printRaceWinner(List<String> raceWinner) {
		StringBuilder winnerList = new StringBuilder();
		winnerList.append(FINAL_WIN_MESSAGE);

		IntStream.range(0, raceWinner.size() - 1)
			.forEach(i -> winnerList.append(raceWinner.get(i)).append(", "));
		winnerList.append(raceWinner.get(raceWinner.size() - 1));

		System.out.println(winnerList);
	}
}
