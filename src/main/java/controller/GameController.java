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
	}
}
