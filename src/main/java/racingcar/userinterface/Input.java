package racingcar.userinterface;

import java.util.Arrays;
import java.util.List;

public class Input {
	public List<String> getCarNameList() {
		String noticeMessage = "자동차 이름을 입력해 주세요.";
		String regularExpression = "^[a-zA-Z][a-zA-Z0-9,]*";
		String errorMessage = "[ERROR] 반복횟수는 1 이상의 정수만 입력 가능합니다.";
		InputModule carNames = new InputModule(noticeMessage, regularExpression, errorMessage);
		String[] carNameArr = carNames.getValue().split(",");
		List<String> carNameList = Arrays.asList(carNameArr);

		return carNameList;
	}

	public int getRepeatNum() {
		String noticeMessage = "반복 횟수 입력해 주세요.";
		String regularExpression = "^[1-9][0-9]*";
		String errorMessage = "[ERROR] 반복횟수는 1 이상의 정수만 입력 가능합니다.";
		InputModule repeatModule = new InputModule(noticeMessage, regularExpression, errorMessage);
		int repeatNum = Integer.parseInt(repeatModule.getValue());

		return repeatNum;
	}
}
