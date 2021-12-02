package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputHandler {
	public static String[] getNameInput() {
		String[] name = Console.readLine().trim().split(",", -1);
		Validator.validateNameInput(name);
		return name;
	}
}
