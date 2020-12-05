package racingcar;

import java.util.Scanner;

import utils.ConsoleManager;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		ConsoleManager consoleManager = new ConsoleManager(scanner);

		String[] carNames = consoleManager.getCarNamesForInput();
	}
}
