package controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

	private InputController() {
	}

	public static String[] inputRacingCarNames() {
		String[] racingCarNames = Console.readLine().split(",");
		return racingCarNames;
	}
}
