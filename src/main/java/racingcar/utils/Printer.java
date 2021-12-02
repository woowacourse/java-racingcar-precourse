package racingcar.utils;

import static racingcar.utils.Constant.*;

public class Printer {
	public static void printInputNameMsg() {
		System.out.println(INPUT_NAME_MSG);
	}

	public static void printErrorMsg(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
