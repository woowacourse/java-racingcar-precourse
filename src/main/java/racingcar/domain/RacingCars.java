package racingcar.domain;

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
		int maxPosition = getMaxPosition();
		return racingCars.stream()
			.filter(car -> car.isInPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public int getMaxPosition() {
		return racingCars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}
}
