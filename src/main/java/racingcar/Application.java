package racingcar;

import java.util.Scanner;

import utils.CarNameInputValidator;

public class Application {
	private static final String DELIMITER = ",";
	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		inputCarNames(scanner);
	}

	private static void inputCarNames(Scanner scanner) {
		RacingGame racingGame = RacingGame.getInstance();
		racingGame.clearCars();
		
		System.out.println(INPUT_NAME_MESSAGE);
		String[] names = scanner.nextLine().split(DELIMITER);

		try {
			CarNameInputValidator.inputVaildCheck(names);
			racingGame.addCarByNames(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputCarNames(scanner);
		}
	}
}
