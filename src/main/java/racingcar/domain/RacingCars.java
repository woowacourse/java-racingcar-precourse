package racingcar.domain;

import static racingcar.constant.GameErrorMessage.*;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars(List<String> carNames) {
		racingCars = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void move() {
		racingCars.forEach(Car::movePosition);
	}

	public String getExecutionForEachOrderMessage() {
		StringBuilder result = new StringBuilder();
		racingCars.forEach(car -> result.append(car.getNameAndPositionMessage()));
		return result.toString();
	}

	public List<String> getWinner() {
		Car maxPositionCar = getMaxPositionCar();
		return getSamePositionCars(maxPositionCar);
	}

	private Car getMaxPositionCar() {
		return racingCars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException(CAR_LIST_EMPTY_ERROR));
	}

	private List<String> getSamePositionCars(Car maxPositionCar) {
		return racingCars.stream()
			.filter(maxPositionCar::isSamePosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
