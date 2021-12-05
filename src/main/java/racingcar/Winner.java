package racingcar;

import static utils.Message.*;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

	List<String> names;
	StringBuilder result = new StringBuilder();

	public void decide(List<Car> cars) {
		pick(cars);
		print();
	}

	private void pick(List<Car> cars) {
		int firstPosition = calculateFirstPosition(cars);

		names = cars.stream()
			.filter(car -> car.getPosition() == firstPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int calculateFirstPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	private void print() {
		int size = names.size();
		String[] winners = names.toArray(new String[size]);

		result
			.append(FINAL_WIN_MESSAGE)
			.append(String.join(SEPARATOR, winners));

		System.out.println(result);
	}
}
