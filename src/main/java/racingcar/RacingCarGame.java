package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차 경주 게임의 처리 흐름을 제어하는 Class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class RacingCarGame {
	private final ArrayList<Car> carList = new ArrayList<>();
	private int numberOfTimes;

	public void start() {
		prepareCarList();
		prepareNumberOfTimes();
		System.out.printf("%n실행 결과%n");
		for (int i = 0; i < numberOfTimes; i++) {
			play();
			System.out.println();
		}
	}

	private void play() {
		for (Car car : carList) {
			if(Randoms.pickNumberInRange(0,9) >= 4) {
				car.move();
			}
			car.printPosition();
		}
	}

	private void prepareCarList() {
		boolean validated;
		do {
			try {
				setCarList(Computer.askCarNames());
				validated = true;
			} catch (IllegalArgumentException e) {
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
				validated = false;
			}
		} while (!validated);
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
			if (numberOfTimes > 0) {
				return;
			}
			System.out.println("[ERROR] 시도 회수는 1 이상이어야 합니다.");
			throw new IllegalArgumentException("시도 회수는 1 이상이어야 한다");
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 시도 회수는 숫자여야 합니다.");
			throw new IllegalArgumentException("시도 회수는 숫자여야 한다");
		}
	}

	private void validateCarName(String carName) throws IllegalArgumentException {
		if (carName.length() <= 5) {
			return;
		}
		System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
		throw new IllegalArgumentException("자동차 이름은 5자 이하여야 한다");
	}
}
