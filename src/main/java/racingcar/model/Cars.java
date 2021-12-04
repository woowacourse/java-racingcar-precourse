package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createCarsByNames(List<String> names) {
		List<Car> cars = toCarListByNames(names);
		return new Cars(cars);
	}

	private static List<Car> toCarListByNames(List<String> names) {
		return names.stream()
			.map(Car::new)
			.collect(toList());
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<Car> getRacingWinners() {
		Car winner = getAnyWinner();
		List<Car> winners = getCarsPositionExactlySame(winner);
		return Collections.unmodifiableList(winners);
	}

	private Car getAnyWinner() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 차가 존재하지 않습니다."));
	}

	private List<Car> getCarsPositionExactlySame(Car winner) {
		return cars.stream()
			.filter(winner::isSamePosition)
			.collect(toList());
	}

	public void moveOrStop() {
		for (Car car : cars) {
			CarPower carPower = CarPower.createRandomPower();
			car.moveOrStop(carPower);
		}
	}
}
