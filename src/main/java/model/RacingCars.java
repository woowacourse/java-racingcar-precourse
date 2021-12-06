package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
	private List<Car> cars = new ArrayList<>();

	public RacingCars(String[] carNames) {
		makeCars(carNames);
	}

	private void makeCars(String[] carNames) {
		cars = Arrays.stream(carNames).
			map(car -> new Car(car)).
			collect(Collectors.toList());
	}
}
