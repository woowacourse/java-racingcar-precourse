package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String CARS_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 경주하는 자동차가 없습니다.";

	private List<Car> cars = new LinkedList<>();

	public Cars(String[] names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public void racing() {
		cars.forEach(car -> {
			car.moveForward();
			car.printState();
		});
		System.out.println();
	}

	public List<Car> findWinners() {
		Car maxPositionCar = cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException(CARS_IS_EMPTY_ERROR_MESSAGE));

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}
}
