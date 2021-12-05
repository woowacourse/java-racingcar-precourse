package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import racingcar.exception.InputException;
import racingcar.view.InputView;

public class Cars {
	List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void join(String carNames) {
		try {
			String[] validCarNames = InputException.isValidCarNames(carNames);
			for (String carName : validCarNames) {
				cars.add(new Car(carName));
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			join(InputView.getInputRaceCar());
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public Car getCarWithMaxPosition() {
		return cars.stream().max(Comparator.comparingInt(Car::getPosition)).get();
	}

}
