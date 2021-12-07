package racingcar.domain.car;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarSet {
	private static final String ERROR_EMPTY = "이름은 빈 문자열일 수 없습니다.";
	private static final String ERROR_DUPLICATION = "이름은 중복될 수 없습니다.";

	private final List<Car> cars;

	public CarSet(List<Car> cars) {
		validate(cars);
		this.cars = cars;
	}

	private void validate(List<Car> cars) {
		validateEmpty(cars);
		validateDistinct(cars);
	}

	private void validateEmpty(List<Car> cars) {
		if (cars.size() == 0) {
			throw new IllegalArgumentException(ERROR_EMPTY);
		}
	}

	private void validateDistinct(List<Car> cars) {
		Set<String> nameSet = cars.stream().map(Car::getName).collect(Collectors.toSet());
		if (nameSet.size() != cars.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATION);
		}
	}
}
