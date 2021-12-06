package controller;

import camp.nextstep.edu.missionutils.Console;
import utils.NameInputValidator;
import utils.CountInputValidator;

public class InputController {
	private final static boolean INPUT_ERROR = true;

	private InputController() {
	}

	public static String[] inputRacingCarNames() {
		while (INPUT_ERROR) {
			try {
				String racingCarNames = Console.readLine();
				return NameInputValidator.isValideRacingCarNames(racingCarNames);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static int inputNumberOfCarRaces() {
		while (INPUT_ERROR) {
			try {
				String raceCount = Console.readLine();
				return CountInputValidator.isValideRaceCount(raceCount);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
