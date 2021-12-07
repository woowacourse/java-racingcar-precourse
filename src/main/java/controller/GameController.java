package controller;

import java.util.StringJoiner;

import model.RacingCarGame;
import view.Display;

public class GameController {

	private GameController() {
	}

	public static void runGame() {
		Display.askInputRacingCarNames();
		RacingCarGame racingCarGame = new RacingCarGame(InputController.inputRacingCarNames());
		Display.askInputNumberOfCarRaces();
		racingCarGame.makeRaceCount(InputController.inputNumberOfCarRaces());
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

	private static void showRacingCarGameWinner(String[] racingCarGameWinners) {
		Display.showWinnerMessage(racingCarGameWinners);
	}
}
