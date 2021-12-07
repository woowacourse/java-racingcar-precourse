package racingcar.view;

import static racingcar.constant.StringConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class ExecutionView implements View, InputView {
	@Override
	public void printView() {
		System.out.println(PROCESS_INPUT_MESSAGE);
	}

	@Override
	public String getUserInput() {
		return Console.readLine();
	}
}
