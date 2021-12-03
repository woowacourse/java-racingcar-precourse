package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

import racingcar.util.Validator;

public class InputView {

	static Validator validator = new Validator();

	public static String getStringInput() {
		return readLine();
	}

	public static int getIntInput() {
		String input = readLine();
		validator.validateNumber(input);
		return Integer.parseInt(input);
	}
}
