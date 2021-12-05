package controller;

import java.util.ArrayList;

import model.CarList;
import model.NumberList;
import utils.MissionUtils;
import view.NameInputView;
import view.OutputView;
import view.TurnInputView;

public class GameController {
	private static final String DELIMITER = ",";
	public static void runGame() {
		OutputView outputViewer = new OutputView();
		NameInputView nameInputViewer = new NameInputView();
		TurnInputView turnInputViewer = new TurnInputView();
		outputViewer.noticeNameInput();
		ArrayList<String> nameInput = MissionUtils.parseInput(nameInputViewer.getInput(), DELIMITER);
		CarList carList = new CarList(nameInput);
		outputViewer.noticeTurnInput();
		int totalTurns = Integer.valueOf(turnInputViewer.getInput());
		for (int nowTurn = 0; nowTurn < totalTurns; nowTurn++) {
			NumberList numberList = new NumberList(nameInput.size());
			carList.forwardAllCars(numberList.getOverThresholdIndexes());
			outputViewer.viewAfterOneTurn(nameInput, carList.getAllPosition());
		}
		outputViewer.viewWinner(carList.getWinnerName());
	}
}
