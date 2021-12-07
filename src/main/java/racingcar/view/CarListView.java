package racingcar.view;

import static racingcar.constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class CarListView implements View, InputView {
	@Override
	public void printView() {
		System.out.println(START_MESSAGE);
	}

	@Override
	public String getUserInput() {
		return Console.readLine();
	}

}
