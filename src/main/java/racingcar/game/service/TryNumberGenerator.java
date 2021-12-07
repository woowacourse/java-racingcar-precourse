package racingcar.game.service;

import racingcar.common.input.TryNumberInput;
import racingcar.common.model.OutputContainer;
import racingcar.game.model.TryNumber;

public class TryNumberGenerator {
	public static TryNumber generateTryNumber() {
		while (true) {
			TryNumberInput tryNumberInput = new TryNumberInput();
			try {
				final String tryNumber = tryNumberInput.receive();
				return new TryNumber(tryNumber);
			} catch (IllegalArgumentException e) {
				OutputContainer.printMessage(e.getMessage());
			}

		}

	}

}
