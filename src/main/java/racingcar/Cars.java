package racingcar;

import utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS_REQUIRED = 1;
	private static final int CAR_NAME_LENGTH_LOWER_BOUND = 1;
	private static final int CAR_NAME_LENGTH_UPPER_BOUND = 5;
	private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "[ERROR] 차 이름이 중복됩니다.";
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 차 이름은 " + CAR_NAME_LENGTH_LOWER_BOUND + "자 이상 "
			+ CAR_NAME_LENGTH_UPPER_BOUND + "자 이하여야 합니다.";
	private static final String CAR_VOID_NAME_ERROR_MESSAGE = "[ERROR] 차 이름은 공백일 수 없습니다";
	private static final String NUMBER_OF_CARS_ERROR_MESSAGE = "[ERROR] 차 이름이 적어도 " + MINIMUM_NUMBER_OF_CARS_REQUIRED + "개 필요합니다.";
	private static final int START_INCLUSIVE_NUMBER = 0;
	private static final int END_EXCLUSIVE_NUMBER = 10;
	private static final String WINNER_DELIMITER = ", ";

	private final List<Car> cars;

	public Cars(List<Car> cars) throws IllegalArgumentException {
		validateCarAmount(cars);
		validateDuplicateCarName(cars);
		validateCarNameLength(cars);
		validateVoidCarName(cars);
		this.cars = cars;
	}

	private void validateCarAmount(List<Car> cars) throws IllegalArgumentException {
		if (cars.size() == 0) {
			throw new IllegalArgumentException(NUMBER_OF_CARS_ERROR_MESSAGE);
		}
	}

	private long countUniqueCarName(List<Car> cars) {
		return cars.stream()
				.map(Car::getName)
				.distinct()
				.count();
	}

	private void validateDuplicateCarName(List<Car> cars) throws IllegalArgumentException {
		if (countUniqueCarName(cars) != cars.size()) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private void validateCarNameLength(List<Car> cars) throws IllegalArgumentException {
		for (Car car : cars) {
			if (car.getNameLength() < CAR_NAME_LENGTH_LOWER_BOUND || CAR_NAME_LENGTH_UPPER_BOUND < car.getNameLength()) {
				throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
			}
		}
	}

	private void validateVoidCarName(List<Car> cars) throws IllegalArgumentException {
		for (Car car : cars) {
			if (car.hasEmptyName()) {
				throw new IllegalArgumentException(CAR_VOID_NAME_ERROR_MESSAGE);
			}
		}
	}

	public void moveCars() {
		for (Car car : cars) {
			int randomNumber = RandomUtils.nextInt(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER);
			car.changePosition(randomNumber);
		}
	}

	private String getCarPositionStatus(Car car) {
		return car.getName() + " : " + car.getVisualCarPosition();
	}

	public void getCarPositionAnnouncement() {
		for (Car car : cars) {
			System.out.println(getCarPositionStatus(car));
		}
	}

	private int getLeadingPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.getAsInt();
	}

	public String getWinners() {
		int LeadingPosition = getLeadingPosition();
		return cars.stream()
				.filter(car -> car.getPosition() == LeadingPosition)
				.map(Car::getName)
				.collect(Collectors.joining(WINNER_DELIMITER));
	}
}
