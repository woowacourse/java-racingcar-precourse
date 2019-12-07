package view;

import java.util.List;
import java.util.Scanner;

import validation.CarNameValidator;
import validation.CarNamesValidator;
import validation.Validator;

public class InputView {
	private static final String CAR_NAME_DELIMITER = ",";
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Validator carNamesValidator = new CarNamesValidator(new CarNameValidator());

	private static void printGetCarNamesMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static List<String> getCarNames() {
		try {
			printGetCarNamesMessage();
			List<String> names = List.of(SCANNER.nextLine().split(CAR_NAME_DELIMITER));
			carNamesValidator.validate(names);
			return names;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}
	}

	private static void printGetTrialCountMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static int getTrialCount() {
		printGetTrialCountMessage();
		return SCANNER.nextInt();
	}
}
