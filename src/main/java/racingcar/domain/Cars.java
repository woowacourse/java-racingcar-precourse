package racingcar.domain;

import static racingcar.resource.MessageResoruce.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int LENGTH_MIN = 0;

	private final List<Car> cars;

	public Cars(final String names) {
		this.cars = creatCars(names);
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> creatCars(final String names) {
		List<Car> carList = new ArrayList<>();
		String[] carNames = getStrings(names);

		for (String carName : carNames) {
			carList.add(new Car(carName));
		}

		return carList;
	}

	public void move() {
		cars.forEach(car -> {
			RandomNumberGenerator generator = new RandomNumberGenerator();
			car.move(generator);
		});
	}

	private String[] getStrings(final String names) {
		String[] carNames = names.split(OUTPUT_DELIMETER);

		if (carNames.length == LENGTH_MIN) {
			throw new IllegalArgumentException(ERROR_CAR_NAME_NOT_ONLY_COMMA);
		}
		
		return carNames;
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public List<String> findWinners() {
		return cars.stream()
			.filter(car -> car.isWinner(getMaxPosition()))
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
