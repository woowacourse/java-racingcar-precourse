package racingcar;

public class RacingGame {
	private PlayTime targetPlayTime = new PlayTime();
	private PlayTime currentPlayTime = new PlayTime();

	public void run() {
		initPlayTime();
	}

	private void initPlayTime() {
		targetPlayTime.getInput();
	}
}
