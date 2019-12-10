package domain;

import java.util.Scanner;

public class User {
	private Scanner userInput;
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	User() {
		userInput = new Scanner(System.in);
	}

	public String getCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		return getUserInput();
	}

	public int getCarMoveCount() {
		System.out.println(INPUT_MOVE_COUNT_MESSAGE);
		return Integer.parseInt(userInput.next());
	}

	private String getUserInput() {
		return userInput.next();
	}
}
