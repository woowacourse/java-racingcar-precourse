package racingcar;

import java.util.ArrayList;

public class Cars {
	private ArrayList<Car> cars = new ArrayList<>();

	public Cars(String[] carNames) {
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}
}
