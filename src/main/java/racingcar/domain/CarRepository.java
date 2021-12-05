package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
	private static final int FIRST_INDEX_OF_LIST = 0;
	List<Car> carList = new ArrayList<>();

	public void createCars(String[] names) {
		for (String name : names) {
			carList.add(new Car(name));
		}
	}

	public void attemptCarsMoving() {
		for (Car car : carList) {
			car.attemptMoving();
		}
	}

	public List<String> getWinnerCarsName() {
		return getWinnerCars().stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public List<String> getCarsStatusByFormatter() {
		return carList.stream()
			.map(Car::getStatusByFormatter)
			.collect(Collectors.toList());
	}

	private List<Car> getWinnerCars() {
		List<Car> ascendingSortedCars = getAscendingSortedCars();
		List<Car> winnerCars = new ArrayList<>();
		Car winnerCar = ascendingSortedCars.get(FIRST_INDEX_OF_LIST);
		for (Car car : ascendingSortedCars) {
			if (winnerCar.isSamePosition(car)) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}

	private List<Car> getAscendingSortedCars() {
		return carList.stream()
			.sorted()
			.collect(Collectors.toList());
	}
}