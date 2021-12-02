package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.handler.PrintHandler;

public class CarList {
	private final List<Car> list;

	public CarList(String[] names) {
		list = new ArrayList<>();
		createCars(names);
	}

	public void playOnce() {
		list.forEach(Car::playOnce);
	}

	public void getWinner() {
		int winnerPosition = calculateWinnerPosition();
		printWinner(list.stream()
			.filter(car -> car.getPosition() >= winnerPosition)
			.collect(Collectors.toList()));
	}

	private void createCars(String[] names) {
		Arrays.stream(names).forEach(name -> {
			Car car = new Car(name.trim());
			list.add(car);
		});
	}

	private void printWinner(List<Car> winnerList) {
		if (winnerList.size() == 1) {
			PrintHandler.printWinner(winnerList.get(0));
			return;
		}
		PrintHandler.printWinners(winnerList);
	}

	private int calculateWinnerPosition() {
		int winnerPosition = 0;
		for (Car car : list) {
			if (car.getPosition() > winnerPosition) {
				winnerPosition = car.getPosition();
			}
		}
		return winnerPosition;
	}
}
