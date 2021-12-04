package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
	public static String[] getNameInput() {
		return Console.readLine().trim().split(",", -1);
	}

	public static String getNumberInput() {
		return Console.readLine().trim();
	}
}
