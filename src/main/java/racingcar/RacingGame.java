package racingcar;

public class RacingGame {

	private PlayTime targetPlayTime = new PlayTime();
	private PlayTime currentPlayTime = new PlayTime();
	private Cars cars;

	public void run() {
		initPlayTime();
		initCars();
	}

	private void initPlayTime() {
		targetPlayTime.getInput();
	}

	private void initCars() {
		Cars.createCars();
	}
}
