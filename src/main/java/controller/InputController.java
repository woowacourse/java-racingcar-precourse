package controller;

import camp.nextstep.edu.missionutils.Console;
import utils.InputValidator;

public class InputController {

	private InputController() {
	}

	public static String[] inputRacingCarNames() {
		while (true) {
			try {
				String racingCarNames = Console.readLine();
				return InputValidator.isValideRacingCarNames(racingCarNames);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
