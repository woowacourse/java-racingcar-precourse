package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(Names names) {
		this.cars = names.getNames().stream()
			.map(Car::of)
			.collect(Collectors.toList());
	}

	public static Cars from(Names names) {
		return new Cars(names);
	}

	public void moveCars() {
		this.cars
			.forEach(Car::move);
	}
}
