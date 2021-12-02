package racingcar.controller;

import racingcar.util.Converter;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public void run() {
		String[] carNames = getCarNames();
		int stageNum = getStageNum();
	}

	private int getStageNum() {
		int stageNum = -1;
		do {
			try {
				stageNum = enterStageNum();
			} catch (IllegalArgumentException e) {
				printErrorMessage(e);
			}
		} while (stageNum == -1);

		return stageNum;
	}

	private String[] getCarNames() {
		String[] names = null;
		do {
			try {
				names = enterCarName();
			} catch (IllegalArgumentException e) {
				printErrorMessage(e);
			}
		} while (names == null);

		return names;
	}

	private void printErrorMessage(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}

	private int enterStageNum() {
		OutputView.printEnterStageNum();
		String input = InputView.readLine();
		int stageNum = Converter.toInt(input);
		Validator.validateStageNum(stageNum);

		return stageNum;
	}

	private String[] enterCarName() {
		OutputView.printEnterCarNames();
		String input = InputView.readLine();
		String[] names = Converter.toStringArray(input);
		Validator.validateCarNames(names);

		return names;
	}
}
