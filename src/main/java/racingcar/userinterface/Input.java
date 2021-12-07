package racingcar.userinterface;

import static racingcar.utils.Notice.*;

import java.util.Arrays;
import java.util.List;

public class Input {
	public List<String> getCarNameList() {
		String regularExpression = "^[a-zA-Z][a-zA-Z0-9,]*";
		InputModule carNames = new InputModule(regularExpression, CAR_NAME_INPUT_REGULAR);
		String[] carNameArr = carNames.getValue().split(",");

		return Arrays.asList(carNameArr);
	}

	public int getRepeatNum() {
		String regularExpression = "^[1-9][0-9]*";
		InputModule repeatModule = new InputModule(regularExpression, REPEAT_NUM_INPUT_REGULAR);

		return Integer.parseInt(repeatModule.getValue());
	}
}
