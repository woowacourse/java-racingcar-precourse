package racingcar;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<String> carNames) {
		cars = carNames.stream()
			.map(Car::new)
			.collect(toList());
	}
}
