package racingcar.domain;

import static racingcar.util.SymbolicConstantUtil.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.NumberGeneratePolicy;

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
		return new Cars(carsName.split(COMMA, SPLIT_LIMIT));
	}

	public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
		cars.forEach(car -> car.drive(numberGeneratePolicy.generateNumber()));
	}

	public List<Car> getWinners() {
		final Car maxPositionCar = findMaxPositionCar();
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 자동차가 존재하지 않습니다."));
	}

	public List<Car> getDriveRecord() {
		return cars;
	}
}
