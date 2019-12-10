package gameRunner;

import static view.OutputView.*;

import java.util.List;

import util.StringParsing;
import view.InputView;

public class GameMachine {
	private InputView inputView;

	public GameMachine() {
		this.inputView = new InputView(System.in);
	}

	public void runRacingGame() {

		List<String> names = StringParsing.makeNumbersFromString(inputView.getNames());
		int tryCount = inputView.getTryCount();

		RacingGame racingGame = new RacingGame(names, tryCount);
		racingGame.runRaceAsTryCount();

	}

}
