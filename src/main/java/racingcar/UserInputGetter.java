package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputGetter {

	public static String[] parseCarName(String nameString) {
		return nameString.split(",");
	}

	public static int getNumberOfStage() {
		String trialNumber;

		GamePrinter.getNumberPrint();

		while (true) {
			try {
				trialNumber = Console.readLine();
				UserInputValidator.checkInt(trialNumber);
				return Integer.parseInt(trialNumber);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				GamePrinter.getNumberPrint();
			}
		}
	}

	public static String[] getCarNames() {
		String[] carNames;

		GamePrinter.getNamePrint();

		while (true) {
			try {
				carNames = UserInputGetter.parseCarName(Console.readLine());
				UserInputValidator.checkNameLength(carNames);
				return carNames;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				GamePrinter.getNamePrint();
			}
		}
	}
}
