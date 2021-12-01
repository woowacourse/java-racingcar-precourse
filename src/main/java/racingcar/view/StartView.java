package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class StartView implements InputView {
	private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public String getUserInput() {
		System.out.println(START_MESSAGE);
		String userInput = Console.readLine();
		return userInput;
	}

}
