package racingcar;

import java.util.ArrayList;

/**
 * 자동차 경주 게임의 처리 흐름을 제어하는 Class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class RacingCarGame {
	private ArrayList<Car> carList = new ArrayList<>();

	public void start() {
		boolean validated;
		do {
			try {
				setCarList(Computer.askCarNames());
				validated = true;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
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

	private void validateCarName(String carName) throws IllegalArgumentException {
		if (carName.length() <= 5) {
			return;
		}
		throw new IllegalArgumentException("자동차 이름은 5자 이하여야 한다");
	}
}
