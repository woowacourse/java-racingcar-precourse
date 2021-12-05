package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
	public static final String DELIMITER = ",";

	private final List<Car> cars = new ArrayList<>();

	public void createCars() {
		try {
			String[] carNames = inputCarNames();
			for (String carName : carNames) {
				Car car = new Car(carName);
				cars.add(car);
			}
		} catch (IllegalArgumentException e) {
			createCars();
		}
	}

	private static String[] inputCarNames() {
		return Console.readLine().split(DELIMITER);
	}

	public void move() {
		cars.stream().forEach(Car::move);
	}

	public void showState() {
		cars.stream().forEach(System.out::println);
		System.out.println();
	}

	public List<String> getWinners() {
		return cars.stream()
			.filter(car -> car.isSamePosition(getMaxPosition()))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}
}
