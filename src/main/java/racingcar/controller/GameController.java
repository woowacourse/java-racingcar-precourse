package racingcar.controller;

import static racingcar.model.Constants.ROUND_RESULT;

import java.util.ArrayList;

import racingcar.model.CarNameValidation;
import racingcar.model.RacingCars;
import racingcar.model.RoundCountValidation;
import racingcar.model.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private RacingCars racingCars;
	private int roundNum;

	public void setRacingCars() {
		try {
			String namesString = InputView.carInput();
			new CarNameValidation(namesString).validate();
			ArrayList<String> names = Util.toNameArray(namesString);
			racingCars = new RacingCars(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setRacingCars();
		}
	}

	public void setRoundNum() {
		try {
			String roundNumString = InputView.roundInput();
			new RoundCountValidation(roundNumString).validate();
			this.roundNum = Integer.parseInt(roundNumString);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setRoundNum();
		}
	}

	public void play() {
		System.out.println(ROUND_RESULT);
		for (int i = 0; i < roundNum; i++) {
			OutputView.printRoundResult(racingCars.getRoundResult());
		}
	}

	public void showWinner() {
		OutputView.printWinner(racingCars.getWinners());
	}
}
