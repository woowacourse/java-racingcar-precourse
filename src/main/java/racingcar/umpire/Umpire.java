package racingcar.umpire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.Car;

public class Umpire {
	public List<Car> carList;

	public Umpire(List<Car> cars) {
		carList = cars;
	}

	public List<Car> getWinner() {
		int target = findMaxPosition();

		List<Car> winners = findSamePosition(target);
		return winners;
	}

	private int findMaxPosition() {
		return carList.stream()
			.max(Comparator.comparingInt(Car::getPosition))
			.get()
			.getPosition();
	}

	private List<Car> findSamePosition(int target) {
		return carList.stream()
			.filter(car -> car.getPosition() == target)
			.collect(Collectors.toList());
	}

	public List<String> getWinnersNameList(List<Car> winners) {
		List<String> winnersName = new ArrayList<>();

		winners.stream()
			.forEach(winner -> {
				winnersName.add(winner.getName());
			});
		return winnersName;
	}
}
