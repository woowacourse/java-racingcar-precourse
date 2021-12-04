package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void join(String[] carNames) {

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public Car getCarWithMaxPosition() {
		Comparator<Car> carComparatorByPosition = Comparator.comparingInt(Car::getPosition);
		return cars.stream().max(carComparatorByPosition).orElseThrow(IllegalArgumentException::new);
	}

}
