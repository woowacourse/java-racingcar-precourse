package controller;

import model.RacingCarGame;
import view.Display;

public class GameController {
	private static final int FIRST_WINNER_LOCATION = 0;

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
		int lastWinnerLocation = racingCarGameWinner.length - 1;
		for (int index = FIRST_WINNER_LOCATION; index <= lastWinnerLocation; index++) {
			Display.showWinnerMessage();
			Display.showWinner(racingCarGameWinner[index]);
			isLastWinner(lastWinnerLocation, index);
		}
	}

	private static void isLastWinner(int lastWinnerLocation, int nowWinnerLocation) {
		if (lastWinnerLocation != nowWinnerLocation) {
			Display.putComma();
		}
	}
}
