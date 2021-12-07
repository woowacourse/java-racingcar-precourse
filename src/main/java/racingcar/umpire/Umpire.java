package racingcar.umpire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.Car;

public class Umpire {
	public List<Car> carList;
	public List<Car> winners;

	public Umpire(List<Car> cars) {
		carList = cars;
	}

	public void getWinner() {
		int target = findMaxPosition();

		winners = findSamePosition(target);
	}

	public List<String> getWinnersNameList() {
		List<String> winnersName = new ArrayList<>();

		winners.stream()
			.forEach(winner -> {
				winnersName.add(winner.getName());
			});
		return winnersName;
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

}
