package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import racingcar.exception.InputException;

public class Cars {
	List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void join(String carNames) {
		String[] validCarNames = InputException.isValidCarNames(carNames);
		for (String carName : validCarNames) {
			cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public Car getCarWithMaxPosition() {
		return cars.stream().max(Comparator.comparingInt(Car::getPosition)).get();
	}

}
