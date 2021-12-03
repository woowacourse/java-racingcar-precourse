package racingcar.receiver;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidator;

public class TryCountReceiver {

	public Integer receive() {
		String tryCountString = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
			tryCountString = Console.readLine();

			errorSwitch = new TryCountValidator().validate(tryCountString);
		}

		return Integer.parseInt(tryCountString);
	}
}
