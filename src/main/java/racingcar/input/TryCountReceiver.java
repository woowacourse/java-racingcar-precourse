package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidator;

public class TryCountReceiver {

	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	TryCountValidator tryCountValidator = new TryCountValidator();

	public Integer receive() {
		String tryCountString = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
			System.out.println(INPUT_TRY_COUNT_MESSAGE);
			tryCountString = Console.readLine();

			errorSwitch = tryCountValidator.validate(tryCountString);
		}

		return Integer.parseInt(tryCountString);
	}
}
