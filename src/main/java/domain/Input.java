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

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carNames = scanner.nextLine();
		dividedCarNames = carNames.split(",");
		
		if (!isValidInput(dividedCarNames)) {
			System.out.println("5자 이하의 비어있지 않은 이름만 입력해주세요");
			return enterCarNames();
		}

		return convertArrToList(dividedCarNames);
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
		List<String> temp = new ArrayList<String>();

		for (int i = 0; i < inputString.length; i++) {
			temp.add(inputString[i]);
		}
		
		return temp;
	}
	
	public static int enterRounds() {
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			return Integer.parseInt(scanner.nextLine());
		} catch(IllegalArgumentException e) {
			System.out.println("숫자를 입력해주세요");
			return enterRounds();
		}
	}
}
