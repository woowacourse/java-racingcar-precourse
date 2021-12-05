package racingcar;

public class RacingGame {

	public static final String PLAY_RESULT = "실행 결과";
	private PlayTime targetPlayTime = new PlayTime();
	private PlayTime currentPlayTime = new PlayTime();
	private Cars cars = new Cars();

	public void run() {
		initCars();
		initPlayTime();
		playGame();
	}

	private void initPlayTime() {
		targetPlayTime.getInput();
	}

	private void initCars() {
		cars.createCars();
	}

	private void playGame() {
		System.out.println(PLAY_RESULT);
		while (!targetPlayTime.isSame(currentPlayTime)) {
			cars.move();
			currentPlayTime.increase();
			cars.showState();
		}
	}
}
