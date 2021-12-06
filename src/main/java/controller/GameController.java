package controller;

import model.RacingCarGame;
import view.Display;

public class GameController {
	private static final int SOLO_WINNER_COUNT = 1;

	private GameController() {
	}

	public static void runGame() {
		Display.pleaseInputRacingCarNames();
		RacingCarGame racingCarGame = new RacingCarGame(InputController.inputRacingCarNames());
		Display.pleaseInputNumberOfCarRaces();
		racingCarGame.passRaceCount(InputController.inputNumberOfCarRaces());
		playGame(racingCarGame);
	}

	private static void playGame(RacingCarGame racingCarGame) {
		Display.showExecutionResult();

		while (racingCarGame.isRacingNotFinish()) {
			racingCarGame.playRacingCarGame();
			showRacingCarNowPositions(racingCarGame.giveRacingCarNames(), racingCarGame.giveRacingCarPositions());
		}

		showRacingCarGameWinner(racingCarGame.giveWinner());
	}

	private static void showRacingCarNowPositions(String[] racingCarNames, int[] racingCarPositions) {
		Display.showRacingCarNowPositions(racingCarNames, racingCarPositions);
	}

	private static void showRacingCarGameWinner(String[] racingCarGameWinner) {
		if (racingCarGameWinner.length == SOLO_WINNER_COUNT) {
			Display.showSoloWinner(racingCarGameWinner);
			return;
		}
		Display.showJointWinner(racingCarGameWinner);
	}
}
