package view;

import java.util.List;
import java.util.Scanner;

import validation.CarNameValidator;
import validation.CarNamesValidator;
import validation.TrialCountValidator;
import validation.Validator;

public class InputView {
	private static final String CAR_NAME_DELIMITER = ",";
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Validator carNamesValidator = new CarNamesValidator(new CarNameValidator());
	private static final Validator trialCountValidator = new TrialCountValidator();
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String GET_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	private static void printGetCarNamesMessage() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
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
		System.out.println(GET_TRIAL_COUNT_MESSAGE);
	}

	public static int getTrialCount() {
		try {
			printGetTrialCountMessage();
			int count = Integer.parseInt(SCANNER.nextLine());
			trialCountValidator.validate(count);
			return count;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getTrialCount();
		}
	}
}
