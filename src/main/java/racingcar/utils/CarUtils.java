package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarUtils {

	private CarUtils() {
	}

	public static Cars makeCars(List<String> carNames) {
		List<Car> cars;

		cars = new ArrayList<>();
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
		return new Cars(cars);
	}
}
