package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

	private final RacingGame racingGame = new RacingGame();
	private int rounds;

	public void startGame() {
		initialize();
		racingGame.run(rounds);
		racingGame.getResult();
	}

	private void initialize() {
		setUpParticipants();
		setupRounds();
	}

	private void setUpParticipants() {
		try {
			OutputView.printAskingCarNames();
			racingGame.addParticipants(InputView.getStringInput());
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			setUpParticipants();
		}
	}

	private void setupRounds() {
		try {
			OutputView.printAskingRounds();
			rounds = InputView.getIntInput();
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			setupRounds();
		}
	}
}
