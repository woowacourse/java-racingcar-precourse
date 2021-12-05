package racingcar;

import java.util.List;

public class RacingGame {

	public static final String PLAY_RESULT = "실행 결과";
	public static final String PLAYER_DELIMITER = ", ";
	public static final String FINAL_WINNER = "최종 우승자 : ";
	public static final String ASK_PLAYTIME = "시도할 회수는 몇회인가요?";
	public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private final PlayTime targetPlayTime = new PlayTime();
	private final PlayTime currentPlayTime = new PlayTime();
	private final Cars cars = new Cars();

	public void run() {
		initCars();
		initPlayTime();
		playGame();
	}

	private void initPlayTime() {
		System.out.println(ASK_PLAYTIME);
		targetPlayTime.getInput();
	}

	private void initCars() {
		System.out.println(INPUT_CAR_NAMES);
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
		System.out.println(FINAL_WINNER + String.join(PLAYER_DELIMITER, winnerNames));
	}
}
