package racingcar;

import static racingcar.message.GuideMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.Game;
import racingcar.service.NamingProcess;
import racingcar.validation.NameValidation;
import racingcar.validation.NumberValidation;

public class Application {

	public static void main(String[] args) {
		System.out.println(ENTER_CAR_NAME);
		String[] nameList = getNameList();

		System.out.println(ENTER_NUMBER);
		int trials = Integer.parseInt(getNumber());

		Game.start(nameList, trials);
	}

	private static String[] getNameList() {
		String[] nameList = NamingProcess.parseString(Console.readLine());
		try {
			NameValidation.validateName(nameList);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getNameList();
		}
		return nameList;
	}

	private static String getNumber() {
		String inputNumber = Console.readLine();
		try {
			NumberValidation.validateInputNumber(inputNumber);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getNumber();
		}
		return inputNumber;
	}
}
