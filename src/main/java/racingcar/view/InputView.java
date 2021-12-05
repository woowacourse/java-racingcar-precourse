package racingcar.view;

import static constants.RacingCarConstant.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.GameCountValidator;

public class InputView {
	public static String[] inputCarName() {
		while (true) {
			System.out.println(INPUT_CAR_NAME_MESSAGE);
			String carNameInput = Console.readLine();
			try {
				CarNameValidator.checkCarNameInput(carNameInput);
				String[] tmpCarNames = carNameInput.split(DELIMITER);
				CarNameValidator.checkCarNames(tmpCarNames);
				return tmpCarNames;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static Integer inputGameCount() {
		while (true) {
			System.out.println(INPUT_COUNT_MESSAGE);
			String tmpGameCount = Console.readLine();
			try {
				GameCountValidator.checkGameCount(tmpGameCount);
				return Integer.parseInt(tmpGameCount);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}
}
