package racingcar.model;

import java.util.ArrayList;

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

	public static ArrayList<String> getWinnerNames() {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.isMoreAdvancedPosition(maxPosition)) {
				maxPosition = car.getPosition();
			}
		}
		ArrayList<String> winnerNames = new ArrayList<>();
		for (Car car : cars) {
			if (car.isMaxPosition(maxPosition)) {
				winnerNames.add(car.getName());
			}
		}
		return winnerNames;
	}

}
