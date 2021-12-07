package racingcar.view.classes;

import static racingcar.common.constants.PromptConstants.*;

import java.util.stream.IntStream;

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
				proceedShowResultsStatus();
			}
			if (gameStatus == GameStatus.showFinalStatus) {
				proceedShowFinalStatus();
				break;
			}

		}
	}

	private void proceedShowFinalStatus() {
		printFinalWinners();
	}

	private void printFinalWinners() {
		System.out.print(SHOWING_FINAL_WINNERS_MESSAGE);
		printWinnerList();
	}

	private void printWinnerList() {
		dataHandlerInterface.getWinners().forEach(winner -> {
			System.out.print(winner);
			if (dataHandlerInterface.getWinners().indexOf(winner) != dataHandlerInterface.getWinners().size() - 1) {
				System.out.print(", ");
			}
		});
	}

	private void proceedShowResultsStatus() {
		dataHandlerInterface.makeGameData(names, counts);
		printFullTrackRecord();
		takeToShowFinalStatus();
	}

	private void takeToShowFinalStatus() {
		gameStatus = GameStatus.showFinalStatus;
	}

	private void printFullTrackRecord() {
		System.out.println(SHOWING_RESULTS_MESSAGE);
		System.out.print(dataHandlerInterface.getFullTrackRecord());
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
		if (!names[0].equals("")) {
			gameStatus = GameStatus.inputCountStatus;
		}
	}
}
