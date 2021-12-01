package racingcar;

import java.util.Arrays;

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
	}
}
