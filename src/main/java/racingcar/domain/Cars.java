package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.type.RangeType;

public class Cars {

	private final String INVALID_CAR_NAME_LENGTH = "[ERROR] 자동차 이름의 길이가 잘못되었습니다. 1 ~ 5 글자로 입력해주세요.";
	private final String DUPLICATE_CAR_NAME = "[ERROR] 중복된 자동차 이름이 존재합니다.";
	private final List<Car> cars;
	private int winnerPosition = 0;

	public Cars(List<Car> cars) {
		validateLengthAndDuplicate(cars);
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getWinnerPosition() {
		return winnerPosition;
	}

	private void validateLengthAndDuplicate(List<Car> cars) {
		if (!isValidLength(cars)) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
		}
		if (isDuplicate(cars)) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
		}
	}

	private boolean isDuplicate(List<Car> cars) {
		Set<String> carNames = new HashSet<>();
		for (Car car : cars) {
			if (carNames.contains(car.getName())) {
				return true;
			}
			carNames.add(car.getName());
		}
		return false;
	}

	private boolean isValidLength(List<Car> cars) {
		for (Car car : cars) {
			if (car.getName().length() > RangeType.MAX_NAME_LENGTH.getValue()
				|| car.getName().length() < RangeType.MIN_NAME_LENGTH.getValue()) {
				return false;
			}
		}
		return true;
	}

	public void updateWinnerPosition(int position) {
		winnerPosition = Math.max(winnerPosition, position);
	}
}
