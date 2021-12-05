package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.Car;

public class Cars {
	private final List<Car> cars;

	Cars(String[] carNames) {
		this.cars = Arrays.stream(carNames)
			.map(Car::new)
			.collect(Collectors.toList());
	}
	public List<Car> cars() {
		return cars;
	}
}
