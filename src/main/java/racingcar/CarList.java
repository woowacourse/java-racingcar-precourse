package racingcar;

import java.util.ArrayList;

public class CarList {
	private ArrayList<Car> cars = new ArrayList<>();

	public CarList(String [] carNames){
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}
}
