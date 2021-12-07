package racingcar.game.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.game.model.Car;
import racingcar.game.model.Cars;

public class Result {
	public static final int INIT_POSITION = 0;
	private final Cars cars;
	private final Map<String, Integer> carStatus;

	public Result(final Cars cars) {
		this.cars = cars;
		carStatus = generateCarStatus();
	}

	private Map<String, Integer> generateCarStatus() {
		return cars.getCars().stream()
			.collect(Collectors.toMap(Car::getName, Car::getPosition, (a, b) -> b));
	}

	public List<String> getWinners() {
		final int maxPosition = getMaxPosition();

		return cars.getCars().stream().filter(car -> isWinner(car, maxPosition))
			.map(Car::getName).collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.getCars().stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.orElse(INIT_POSITION);
	}

	private boolean isWinner(final Car car, final int maxPosition) {
		return car.isSamePosition(maxPosition);
	}

	public Map<String, Integer> getCarStatus() {
		return carStatus;
	}

}
