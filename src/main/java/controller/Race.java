package controller;

import domain.MoveCount;
import domain.Names;
import view.InputView;

public class Race {
	public void startRace() {
		Names names = InputView.inputCarNames();

		MoveCount moveCount = InputView.inputMoveCount();
	}
}
