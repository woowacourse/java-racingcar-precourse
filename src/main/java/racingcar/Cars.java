package racingcar;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createCarsByNames(List<String> names) {
		List<Car> cars = toCarListBy(names);
		return new Cars(cars);
	}

	private static List<Car> toCarListBy(List<String> names) {
		return names.stream()
			.map(Car::new)
			.collect(toList());
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<Car> getRacingWinners() {
		int winnerPosition = getWinnerPosition();
		List<Car> winners = getCarsPositionExactlySame(winnerPosition);
		return Collections.unmodifiableList(winners);
	}

	private int getWinnerPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}

	private List<Car> getCarsPositionExactlySame(int winnerPosition) {
		return cars.stream()
			.filter(car -> car.isSamePosition(winnerPosition))
			.collect(toList());
	}
}
