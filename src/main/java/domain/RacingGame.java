package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars;
	private int InjectionId = 1;

	public List<Car> getCars() {
		return cars;
	}

	public RacingGame(List<String> carNames) {
		cars = carNames.stream()
			.map(this::makeOneCar)
			.collect(Collectors.toList());
	}

	private Car makeOneCar(String name) {
		return new Car(name, InjectionId++);
	}
}
