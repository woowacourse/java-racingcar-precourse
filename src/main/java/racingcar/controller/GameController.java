package racingcar.controller;

import java.util.List;

import racingcar.logic.RacingGamePlayer;
import racingcar.view.InputFromUser;
import racingcar.view.OutputView;

public class GameController {
	private final InputFromUser inputFromUser = new InputFromUser();
	private final RacingGamePlayer racingGamePlayer = new RacingGamePlayer();

	public void startGame() {
		String[] carNames = inputFromUser.inputCarName();
		int playCount = inputFromUser.inputGameCount();

		racingGamePlayer.playRacingGame(carNames, playCount);
		List<String> winnerList = racingGamePlayer.judgeWinner();

		OutputView.displayWinners(winnerList);
	}
}
