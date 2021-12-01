package controller;

import java.util.List;

import domain.Car;
import domain.MoveCount;
import view.InputView;

public class Race {
	public void startRace() {
		List<Car> cars = InputView.inputCarNames();
		MoveCount moveCount = InputView.inputMoveCount();
	}
}
