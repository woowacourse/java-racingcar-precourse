package racingcar;

import java.util.*;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS_REQUIRED = 1;
	private static final String DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 중복됩니다.";
	private static final String CAR_NAME_LENGTH_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름은 공백일 수 없습니다";
	private static final String NUMBER_OF_CARS_INPUT_ERROR_MESSAGE = "[ERROR] 차 이름이 적어도 " + MINIMUM_NUMBER_OF_CARS_REQUIRED + "개 필요합니다.";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateNumberOfCars(cars);
		validateDuplicate(cars);
		validateCarNameLength(cars);
		validateEmptiness(cars);
		this.cars = cars;
	}

	private void validateNumberOfCars(List<Car> cars) throws IllegalArgumentException {
		if (cars.size() == 0) {
			throw new IllegalArgumentException(NUMBER_OF_CARS_INPUT_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(List<Car> cars) throws IllegalArgumentException {
		if (cars.stream().distinct().count() != cars.size()) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME_INPUT_ERROR_MESSAGE);
		}
	}

	private void validateCarNameLength(List<Car> cars) throws IllegalArgumentException {
		for  (Car car : cars) {
			if (car.getName().length() < 1 || 5 < car.getName().length()) {
				throw new IllegalArgumentException(CAR_NAME_LENGTH_INPUT_ERROR_MESSAGE);
			}
		}
	}

	private void validateEmptiness(List<Car> cars) throws IllegalArgumentException {
		for  (Car car : cars) {
			if (car.getName().trim().length() == 0) {
				throw new IllegalArgumentException(CAR_NAME_EMPTY_INPUT_ERROR_MESSAGE);
			}
		}
	}

	public int getNumberOfCars() {
		return cars.size();
	}
}
