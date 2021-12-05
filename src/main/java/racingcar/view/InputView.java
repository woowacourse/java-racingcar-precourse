package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String DELIMITER = ",";

	public static String[] inputCarNames() {
		return Console.readLine().split(DELIMITER);
	}
}
