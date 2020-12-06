package inpututils;

import controlexception.UserInputNameLengthException;
import controlexception.UserInputPlayerNumberException;

import java.util.Scanner;

public class InputName extends Input {
	private boolean CHECKEDERROR = false;

	public InputName(Scanner scanner) {
		super(scanner);
	}

	public String[] inputPlayerName() {
		String[] name = new String[0];
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			try {
				name = splitName(scanner.next());
			} catch (UserInputNameLengthException e) {
				System.out.println(e.getMessage());
			} catch (UserInputPlayerNumberException e) {
				System.out.println(e.getMessage());
			}
		} while (CHECKEDERROR == false);
		return name;
	}

	private String[] checkPlayerName(String[] name) {
		checkPersonnel(name.length);
		for (String playerName : name) {
			checkLength(playerName);
		}
		CHECKEDERROR = true;
		return name;
	}

	private void checkLength(String playerName) {
		if (playerName.length() > 5) {
			throw new UserInputNameLengthException(playerName.length());
		}
	}

	private String[] splitName(String name) {
		return checkPlayerName(name.split(","));
	}

	private void checkPersonnel(int playerNumber) {
		if (playerNumber < 2) {
			throw new UserInputPlayerNumberException(playerNumber);
		}
	}
}
