package domain;

import java.util.Scanner;

public class User {
	private Scanner userInput;

	User() {
		userInput = new Scanner(System.in);
	}

	public String getCarNames() {
		return getUserInput();
	}

	public int getCarMoveCount() {
		return Integer.parseInt(userInput.next());
	}

	private String getUserInput() {
		return userInput.next();
	}
}
