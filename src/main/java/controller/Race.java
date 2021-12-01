package controller;

import java.util.List;

import domain.MoveCount;
import domain.Name;
import view.InputView;

public class Race {
	public void startRace() {
		List<Name> names = InputView.inputCarNames();
		MoveCount moveCount = InputView.inputMoveCount();
	}
}
