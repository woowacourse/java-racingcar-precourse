package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		validateSize(cars);
		validateDuplication(cars);
		this.cars = new ArrayList<>(cars);
	}

	public static Cars of(String[] names) {
		List<Car> cars = Arrays.stream(names)
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(cars);
	}

	public static Cars of(List<Car> cars) {
		return new Cars(cars);
	}

	public void moveAll() {
		for (Car car : cars) {
			car.move();
		}
	}

	public String getFinalWinnerName() {
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}

	private int getMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.max(Integer::compare)
			.orElse(-1);
	}

	private void validateSize(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름을 입력해주세요.");
		}
	}

	private void validateDuplication(List<Car> cars) {
		List<String> nameList = cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		Set<String> nameSet = new HashSet<>(nameList);

		if (nameSet.size() != nameList.size()) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
		}
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining("\n"));
	}

	public List<Car> getCars() {
		return new ArrayList<>(cars);
	}
}
