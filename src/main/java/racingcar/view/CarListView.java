package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class CarListView implements View {
	private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	@Override
	public void printView() {
		System.out.println(START_MESSAGE);
	}

	@Override
	public String getUserInput() {
		return Console.readLine();
	}

}
