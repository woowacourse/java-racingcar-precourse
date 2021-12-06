package controller;

import model.RacingCarGame;
import view.Display;

public class GameController {

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

		System.out.println(racingCarGame.giveWinner());
	}

	private static void showRacingCarNowPositions(String[] racingCarNames, int[] racingCarPositions) {
		Display.showRacingCarNowPositions(racingCarNames, racingCarPositions);
	}
}
