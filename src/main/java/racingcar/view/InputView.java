package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String[] inputCarNames() {
		return Console.readLine().split(",");
	}
}
