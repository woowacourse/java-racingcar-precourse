package racingcar.view.classes;

import racingcar.common.classes.GameStatus;
import racingcar.controller.GameDataHandlerInterface;
import racingcar.controller.classes.GameDataHandler;
import racingcar.view.Game;

public class GameMachine implements Game {
	private GameStatus gameStatus = GameStatus.inputNameStatus;
	private StandardInputHandler standardInputHandler = new StandardInputHandler();
	private String[] names;
	private int counts = 0;
	private GameDataHandlerInterface dataHandlerInterface = new GameDataHandler();

	@Override
	public void start() {
		while (true) {
			if (gameStatus == GameStatus.inputNameStatus) {
				proceedInputName();
			}
			if (gameStatus == GameStatus.inputCountStatus) {
				proceedInputCount();
			}
			if (gameStatus == GameStatus.showResultsStatus) {
				dataHandlerInterface.makeGameData(names, counts);
				System.out.print(dataHandlerInterface.getFullTrackRecord());
				break;
			}
			if(gameStatus == GameStatus.showFinalStatus) {

			}

		}
	}

	private void proceedInputCount() {
		standardInputHandler.proceedInputCounts();
		counts = standardInputHandler.getCounts();
		takeToShowResult();
	}

	private void takeToShowResult() {
		if (counts > 0) {
			gameStatus = GameStatus.showResultsStatus;
		}
	}

	private void proceedInputName() {
		standardInputHandler.proceedInputNames();
		names = standardInputHandler.getNames();
		takeToInputCountStatus();
	}

	private void takeToInputCountStatus() {
		if(!names[0].equals("")) {
			gameStatus = GameStatus.inputCountStatus;
		}
	}
}
