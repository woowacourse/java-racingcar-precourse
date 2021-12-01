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
	private ArrayList<Car> carList;

	public void start() {
		setCarList(Computer.askCarNames());
	}

	private void setCarList(String[] carNames) {
		carList = new ArrayList<>();
		for(String carName : carNames) {
			//TODO 예외처리(5자 초과일 때)
			carList.add(new Car(carName));
		}
	}
}
