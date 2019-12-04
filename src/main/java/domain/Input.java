package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Input {
	private static final int MAX_NAME_LEN = 5;
	private static Scanner scanner = new Scanner(System.in);

	public static List<String> enterCarNames() {
		String carNames;
		String[] dividedCarNames;

		do {
			carNames = scanner.nextLine();
			dividedCarNames = carNames.split(",");
		} while (!isValidInput(dividedCarNames));

		return convertArrToList(dividedCarNames);
	}

	private static boolean isValidInput(String[] inputString) {
		for (int i = 0; i < inputString.length; i++) {
			if (inputString[i].length() > MAX_NAME_LEN) {
				return false;
			}
		}
		
		return true;
	}

	private static List<String> convertArrToList(String[] inputString) {
		List<String> temp = new ArrayList<String>();

		for (int i = 0; i < inputString.length; i++) {
			temp.add(inputString[i]);
		}
		
		return temp;
	}
}
