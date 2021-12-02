package racingcar.controller;

import racingcar.util.Converter;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public void run() {
		// 자동차 입력
		boolean inputSwitch = false;

		// do {
		// 	try {
		// 		inputSwitch = false;
		// 		String[] names = enterCarName();
		// 	} catch (IllegalArgumentException e) {
		// 		printErrorMessage(e);
		// 		inputSwitch = true;
		// 	}
		// } while (inputSwitch);

		do {
			try {
				inputSwitch = false;
				OutputView.printEnterStageNum();
				String input = InputView.readLine();
				int stageNum = Converter.toInt(input);
				Validator.validateStageNum(stageNum);
			} catch (IllegalArgumentException e) {
				printErrorMessage(e);
				inputSwitch = true;
			}
		} while (inputSwitch);

	}

	private void printErrorMessage(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}

	private String[] enterCarName() {
		OutputView.printEnterCarNames();
		String input = InputView.readLine();
		String[] names = Converter.toStringArray(input);
		Validator.validateCarNames(names);

		return names;
	}
}
