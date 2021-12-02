package racingcar.controller;

import racingcar.util.Converter;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public void run() {
		// 자동차 입력
		boolean sw = false;
		do {
			try {
				sw = false;
				OutputView.printEnterCarNames();
				String nameStr = InputView.readLine();
				String[] names = Converter.toStringArray(nameStr);
				for (String name : names) {
					Validator.validateCarName(name);
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				sw = true;
			}

		} while (sw);

	}
}
