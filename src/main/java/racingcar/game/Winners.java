package racingcar.game;

import java.util.List;

public class Winners {
	private static final String WINNER_FORMAT = "최종 우승자 : ";
	private static final String DELIMITER = ", ";
	private RacingGame racingGame;

	Winners(RacingGame racingGame) {
		this.racingGame = racingGame;
	}

	public String getWinners() {
		List<String> winnerCarsName = racingGame.findFrontCars();
		return WINNER_FORMAT + String.join(DELIMITER, winnerCarsName);
	}
}
