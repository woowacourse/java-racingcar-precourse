package racingcar;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

class StreamMaker {
	private String inputStr;

	Stream<String> getCarNames() {
		return Stream.of(inputStr.split(","));
	}

	StreamMaker() {
		inputStrOfCarNames();
	}

	private void inputStrOfCarNames() {
		inputStr = Console.readLine();

		if (!inputStr.matches("[a-zA-Z0-9,]+")) {
			throw new IllegalArgumentException("[ERROR] 자동차이름(영문/숫자), 쉼표만 입력 가능합니다.");
		}
	}
}
