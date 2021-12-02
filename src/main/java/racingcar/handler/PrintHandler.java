package racingcar.handler;

import static racingcar.utils.Constant.*;

public class PrintHandler {
	public static void printInputNameMsg() {
		System.out.println(INPUT_NAME_MSG);
	}

	public static void printErrorMsg(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
