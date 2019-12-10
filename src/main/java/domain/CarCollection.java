package domain;

import java.util.List;
import java.util.stream.Collectors;

import util.RandomNumberGenerator;

public class CarCollection {
	private List<Car> cars;
	private int InjectionId = 1;

	public List<Car> getCars() {
		return cars;
	}

	public CarCollection(List<String> carNames) {
		cars = carNames.stream()
			.map(this::makeOneCar)
			.collect(Collectors.toList());
	}

	private Car makeOneCar(String name) {
		return new Car(name, InjectionId++);
	}

	public void tryMoveCars() {
		cars.forEach(x -> x.tryMove(RandomNumberGenerator.generateNumber()));
	}
}
