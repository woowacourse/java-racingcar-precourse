package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.handler.PrintHandler;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] names) {
		cars = new ArrayList<>();
		createCars(names);
	}

	public void playOnce(int[] randomNumbers) {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).playOnce(randomNumbers[i]);
		}
	}

	public void getWinner() {
		int winnerPosition = calculateWinnerPosition();
		printWinner(cars.stream()
			.filter(car -> car.getPosition() >= winnerPosition)
			.collect(Collectors.toList()));
	}

	private void createCars(String[] names) {
		Arrays.stream(names).forEach(name -> {
			Car car = new Car(name.trim());
			cars.add(car);
		});
	}

	private void printWinner(List<Car> winnerList) {
		String winnerNames = winnerList.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		PrintHandler.printWinners(winnerNames);
	}

	private int calculateWinnerPosition() {
		int winnerPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() > winnerPosition) {
				winnerPosition = car.getPosition();
			}
		}
		return winnerPosition;
	}

	public int size() {
		return cars.size();
	}
}
