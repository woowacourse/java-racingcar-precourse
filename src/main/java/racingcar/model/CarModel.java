package racingcar.model;

import static racingcar.constants.GameConstants.*;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.resource.Car;

public class CarModel {
	private static final CarModel carModel = new CarModel();

	private List<Car> carList;

	private CarModel() {
	}

	public static CarModel getCarModel() {
		return carModel;
	}

	public void createCars(List<String> carNames) {
		carList = carNames
			.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void moveAllCars() {
		carList.forEach(this::tryMoving);
	}

	public List<String> getVisualizedPositions() {
		return carList.stream()
			.map(this::getVisualizedPosition)
			.collect(Collectors.toList());
	}

	public List<String> getCarNames() {
		return carList.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public List<String> getWinners() {
		int maxPosition = carList.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);

		return carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private void tryMoving(Car car) {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			car.move();
		}
	}

	private String getVisualizedPosition(Car car) {
		StringBuilder dashedPosition = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			dashedPosition.append(MOVING_GAUGE);
		}
		return dashedPosition.toString();
	}
}
