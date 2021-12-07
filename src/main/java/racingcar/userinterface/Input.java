package racingcar.userinterface;

import java.util.Arrays;
import java.util.List;

public class Input {
	public List<String> getCarNameList() {
		String regularExpression = "^[a-zA-Z][a-zA-Z0-9,]*";
		String errorMessage = "[ERROR] 영문으로 시작하는 이름만 입력 가능합니다.";
		InputModule carNames = new InputModule(regularExpression, errorMessage);
		String[] carNameArr = carNames.getValue().split(",");

		return Arrays.asList(carNameArr);
	}

	public int getRepeatNum() {
		String regularExpression = "^[1-9][0-9]*";
		String errorMessage = "[ERROR] 반복횟수는 1 이상의 정수만 입력 가능합니다.";
		InputModule repeatModule = new InputModule(regularExpression, errorMessage);
		int repeatNum = Integer.parseInt(repeatModule.getValue());

		return repeatNum;
	}
}
