package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputCarNames() {
		System.out.println(Constant.CAR_NAMES_INPUT_ALARM_MESSAGE);
		return Console.readLine();
	}
}
