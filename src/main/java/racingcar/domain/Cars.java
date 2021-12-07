package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

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

	public String getResults() {
		return this.cars.stream()
			.map(Car::getTrackWithName)
			.collect(Collectors.joining(System.lineSeparator()));

	}

	public List<Car> findWinners() {
		return this.cars.stream()
			.filter(car -> car.isSamePosition(getMaxPosition()))
			.collect(Collectors.toList());

	}

	private int getMaxPosition() {
		return this.cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(NoSuchElementException::new);
	}
}
