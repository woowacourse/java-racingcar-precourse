package racingcar.domain;

import static racingcar.util.SymbolicConstantUtil.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.RandomNumberGeneratePolicy;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	private Cars(String[] cars) {
		this(Arrays.stream(cars)
			.map(Car::new)
			.collect(Collectors.toList()));
	}

	public static Cars fromString(String carsName) {
		return new Cars(carsName.split(COMMA));
	}

	public void driveAll(RandomNumberGeneratePolicy randomNumberGeneratePolicy) {
		cars.forEach(car -> car.drive(randomNumberGeneratePolicy.generateNumber()));
	}

	public List<Car> getWinners() {
		final int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.max(Comparator.comparing(car -> car.getPosition()))
			.orElseThrow(RuntimeException::new)
			.getPosition();
	}

	public List<Car> getDriveRecord() {
		return cars;
	}
}
