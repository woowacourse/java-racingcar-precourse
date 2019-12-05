package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Input {
	private static final int MAX_LEN_OF_NAME = 5;
	private static final int MIN_LEN_OF_NAME = 1;
	private static final int MIN_ROUNDS = 1;
	
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		String[] carNames;
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = SCANNER.nextLine().trim().split(",");
			checkIfValidCarNames(carNames);
			return convertArrToList(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterCarNames();
		}
	}
	
	private static void checkIfValidCarNames(String[] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			checkIfValidCarName(carNames[i]);
		}
	}
	
	private static void checkIfValidCarName(String carName) {
		if ((carName.length() > MAX_LEN_OF_NAME)
				|| (carName.length() < MIN_LEN_OF_NAME)) {
			throw new IllegalArgumentException("5자 이하의 비어있지 않은 이름만 입력해주세요");
		}
	}
	
	private static List<String> convertArrToList(String[] inputStringArr) {
		List<String> outputList = new ArrayList<String>();
		for (int i = 0; i < inputStringArr.length; i++) {
			outputList.add(inputStringArr[i]);
		}
		return outputList;
	}

	public static int enterRounds() {
		int rounds;
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			rounds = enterInt();
			checkIfValidRounds(rounds);
			return rounds;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterRounds();
		}
	}

	private static int enterInt() {
		try {
			return Integer.parseInt(SCANNER.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("숫자를 입력해주세요");
			return enterInt();
		}
	}
	
	private static void checkIfValidRounds(int rounds) {
		if(rounds < MIN_ROUNDS) {
			throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
		}
	}

}