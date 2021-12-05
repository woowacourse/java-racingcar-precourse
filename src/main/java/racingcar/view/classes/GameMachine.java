package racingcar.view.classes;

import racingcar.common.classes.GameStatus;
import racingcar.view.Game;

public class GameMachine implements Game {
	private GameStatus gameStatus = GameStatus.inputNameStatus;
	private StandardInputHandler standardInputHandler = new StandardInputHandler();
	private String[] names;

	@Override
	public void start() {
		while (true) {
			standardInputHandler.proceedInputNames();
		}
	}
}
