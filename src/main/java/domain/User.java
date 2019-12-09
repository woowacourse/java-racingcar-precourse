package domain;

import java.util.Scanner;

public class User {
	private Scanner playerInput;

	User() {
		playerInput = new Scanner(System.in);
	}

	public String getCarNames() {
		return getPlayerInput();
	}

	private String getPlayerInput() {
		return playerInput.next();
	}

}
