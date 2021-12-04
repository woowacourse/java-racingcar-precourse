package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRepository {
	static final int MIN_RANDOM_NUMBER = 0;
	static final int MAX_RANDOM_NUMBER = 9;
	private static final ArrayList<Car> cars = new ArrayList<>();

	public static void addCar(Car car) {
		cars.add(car);
	}

	public static ArrayList<Car> getCars() {
		return cars;
	}

	public static void moveCars() {
		for (Car car : cars) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
			car.move(randomNumber);
		}
	}

	public static int getMaxPositionOfCars() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}

	public static List<String> getWinnerNames() {
		int maxPosition = getMaxPositionOfCars();
		return cars.stream()
			.filter(car -> car.isMaxPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

}
