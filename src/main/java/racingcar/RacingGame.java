package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	private static final String RESULT_MESSAGE = "실행 결과";

	private Car[] cars;
	private int turn;

	public void start() {
		String[] carInput = Request.carInput();
		cars = Arrays.stream(carInput)
			.map(Car::new)
			.toArray(Car[]::new);
		turn = Request.turnInput();
		System.out.println(RESULT_MESSAGE);
		startRace();
	}

	private void startRace() {
		for (int i = 0; i < turn; i++) {
			for (Car car : cars) {
				if (Randoms.pickNumberInRange(0, 9) >= 4) {
					car.moveForward();
				}
			}
		}
	}
}
