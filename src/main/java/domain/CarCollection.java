package domain;

import static util.CustomErrorMessage.*;

import java.util.List;
import java.util.stream.Collectors;

import util.RandomNumberGenerator;

public class CarCollection {
	private List<Car> cars;
	private int InjectionId = 1;

	List<Car> getCars() {
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

	public List<String> getCarsPositionWithRacingFormat() {
		return cars.stream()
			.map(Car::getPositionWithRacingFormat)
			.collect(Collectors.toList());
	}

	public List<Car> getCarsWinner() {
		int maxPosition = cars.stream()
			.max(new Car.CarComparator())
			.orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MAX_IN_THIS_LIST))
			.getPosition();

		return cars.stream()
			.filter(c -> c.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	public void tryMoveCars() {
		cars.forEach(x -> x.tryMove(RandomNumberGenerator.generateNumber()));
	}
}
