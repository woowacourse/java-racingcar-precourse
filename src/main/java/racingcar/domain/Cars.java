package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private static final String DELIMETER = ",";

	private final List<Car> cars;

	public Cars(final String names) {
		this.cars = creatCars(names);
	}

	public List<Car> creatCars(final String names) {
		List<Car> carList = new ArrayList<>();
		String[] carNames = names.split(DELIMETER);

		for (String carName : carNames) {
			carList.add(new Car(carName));
		}

		return carList;
	}
}
