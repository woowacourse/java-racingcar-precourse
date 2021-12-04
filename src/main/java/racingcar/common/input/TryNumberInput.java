package racingcar.common.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.message.InfoMessage;
import racingcar.common.model.InputFactory;
import racingcar.common.model.OutputContainer;

public class TryNumberInput implements InputFactory {
	@Override
	public String receive() {
		OutputContainer.printMessage(InfoMessage.REQUEST_TRY_COUNT_INPUT_MESSAGE.getMessage());
		String tryNumber = Console.readLine();
		return tryNumber;
	}

}
