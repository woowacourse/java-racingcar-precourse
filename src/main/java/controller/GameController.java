package controller;

import model.RacingCarGame;
import view.Display;

public class GameController {
	private static final int FIRST_WINNER_INDEX = 0;

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
		int lastWinnerIndex = racingCarGameWinner.length - 1;
		Display.showWinnerMessage();
		for (int index = FIRST_WINNER_INDEX; index < racingCarGameWinner.length; index++) {
			Display.showWinner(racingCarGameWinner[index]);
			if (!isLastWinner(lastWinnerIndex, index)) {
				Display.putComma();
			}
		}
	}

	private static boolean isLastWinner(int lastWinnerIndex, int nowWinnerIndex) {
		if (lastWinnerIndex != nowWinnerIndex) {
			return false;
		}
		return true;
	}
}
