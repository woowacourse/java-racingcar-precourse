package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

	public static final String PLAY_RESULT = "실행 결과";
	public static final String PLAYER_DELIMITER = ", ";
	public static final String FINAL_WINNER = "최종 우승자 : ";
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

		judgeWinner();
	}

	private void judgeWinner() {
		List<String> winnerNames = cars.getWinners();
		System.out.printf(FINAL_WINNER);
		System.out.println(String.join(PLAYER_DELIMITER, winnerNames));
	}
}
