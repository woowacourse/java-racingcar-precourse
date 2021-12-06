package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
	private final ArrayList<Car> cars = new ArrayList<>();

	public CarList(String [] carNames){
		for (String carName : carNames) {
			this.cars.add(new Car(carName));
		}
	}

	public void moveAll() {
		for (Car car : this.cars) {
			car.moveForward();
		}
	}

	private List<Car> getWinners() {
		return this.cars.stream()
			.filter(car -> car.getPosition() == getMaxPosition())
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return this.cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}
}
