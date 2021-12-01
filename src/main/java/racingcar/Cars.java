package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	protected final List<Car> cars;

	public Cars(List<String> cars) {
		this.cars = mapCar(cars);
	}

	private List<Car> mapCar(List<String> cars) {
		return cars.stream().map(Car::new).collect(Collectors.toList());
	}

	public List<Integer> getScoreList() {
		List<Integer> scoreList = new ArrayList<>();
		for (Car car : cars) {
			scoreList.add(car.getPosition());
		}
		return scoreList;
	}

	public List<String> getWinner() {
		List<String> winnerList = new ArrayList<>();
		List<Integer> scoreList = getScoreList();
		int max = Collections.max(scoreList);
		for (Car car : cars) {
			if (max == car.getPosition()) {
				winnerList.add(car.getName());
			}
		}
		return winnerList;
	}
}
