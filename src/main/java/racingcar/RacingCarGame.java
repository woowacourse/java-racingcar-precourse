package racingcar;

import java.util.ArrayList;

/**
 * 자동차 경주 게임의 처리 흐름을 제어하는 Class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class RacingCarGame {
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private final ArrayList<Car> carList = new ArrayList<>();
	private int numberOfTimes;

	public void start() {
		prepareCarList();
		prepareNumberOfTimes();
		System.out.printf("%n실행 결과%n");
		for (int i = 0; i < numberOfTimes; i++) {
			play();
		}
		Computer.printWinner(findWinner());
	}

	private void prepareCarList() {
		boolean validated;
		do {
			try {
				setCarList(Computer.askCarNames());
				validated = true;
			} catch (IllegalArgumentException e) {
				Computer.printError(e);
				validated = false;
			}
		} while (!validated);
	}

	private void prepareNumberOfTimes() {
		boolean validated;
		do {
			try {
				setNumberOfTimes(Computer.askHowManyTimes());
				validated = true;
			} catch (IllegalArgumentException e) {
				Computer.printError(e);
				validated = false;
			}
		} while (!validated);
	}

	private void play() {
		for (Car car : carList) {
			car.tryToMove();
			Computer.printCarPosition(car);
		}
		System.out.println();
	}

	private ArrayList<Car> findWinner() {
		ArrayList<Car> winnerList = new ArrayList<>();
		int maxPosition = 0;
		for (Car car : carList) {
			int position = car.getPosition();
			if (position > maxPosition) {
				maxPosition = position;
				winnerList.clear();
			}
			if (position == maxPosition) {
				winnerList.add(car);
			}
		}
		return winnerList;
	}

	private void setCarList(String[] carNames) throws IllegalArgumentException {
		carList.clear();
		for (String carName : carNames) {
			validateCarName(carName);
			carList.add(new Car(carName));
		}
	}

	private void setNumberOfTimes(String strNumberOfTimes) throws IllegalArgumentException {
		try {
			numberOfTimes = Integer.parseInt(strNumberOfTimes);
			validateNumberOfTimes();
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 회수는 숫자여야 합니다.");
		}
	}

	private void validateCarName(String carName) throws IllegalArgumentException {
		if (carName.length() <= MAX_CAR_NAME_LENGTH) {
			return;
		}
		throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
	}

	private void validateNumberOfTimes() throws IllegalArgumentException {
		if (numberOfTimes > 0) {
			return;
		}
		throw new IllegalArgumentException("시도 회수는 1 이상이어야 합니다.");
	}
}
