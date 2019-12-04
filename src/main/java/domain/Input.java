package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Input {
	private static final int MAX_NAME_LEN = 5;
	private static final int MIN_ROUNDS = 0;
	private static Scanner scanner = new Scanner(System.in);

	public static List<String> enterCarNames() {
		String[] carNames;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carNames = scanner.nextLine().split(",");
		if (!isValidInput(carNames)) {
			System.out.println("5자 이하의 비어있지 않은 이름만 입력해주세요");
			return enterCarNames();
		}

		return convertArrToList(carNames);
	}

	private static boolean isValidInput(String[] inputString) {
		for (int i = 0; i < inputString.length; i++) {
			if ((inputString[i].length() > MAX_NAME_LEN) || (inputString[i].length() == 0)) {
				return false;
			}
		}
		
		return true;
	}

	private static List<String> convertArrToList(String[] inputString) {
		List<String> outputList = new ArrayList<String>();

		for (int i = 0; i < inputString.length; i++) {
			outputList.add(inputString[i]);
		}
		
		return outputList;
	}
	
	public static int enterRounds() {
		int rounds = enterInt();
		
		if (rounds < MIN_ROUNDS) {
			System.out.println("0 이상의 숫자를 입력해주세요");
			return enterRounds();
		}
		
		return rounds;
	}
	
	private static int enterInt() {
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			return Integer.parseInt(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println("숫자를 입력해주세요");
			return enterInt();
		}
	}
}