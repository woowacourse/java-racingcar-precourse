package racingcar.common.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.message.InfoMessage;
import racingcar.common.model.InputFactory;
import racingcar.common.model.OutputContainer;

public class CarNameInput implements InputFactory {
	@Override
	public String receive() {
		OutputContainer.printMessage(InfoMessage.REQUEST_CAR_NAME_INPUT_MESSAGE.getMessage());
		String carName = Console.readLine();
		return carName;
	}

}
