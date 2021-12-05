package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
	public static final String DELIMITER = ",";

	static List<Car> cars = new ArrayList<>();

	public static void createCars() {
		String[] carNames = inputCarNames();

		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private static String[] inputCarNames() {
		return Console.readLine().split(DELIMITER);
	}
}
