package racingcar;

public class RacingGame {
	private static final String RESULT_MESSAGE = "실행 결과";

	public void start() {
		Request.carInput();
		Request.turnInput();
		System.out.println(RESULT_MESSAGE);
	}
}
