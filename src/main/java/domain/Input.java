package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Input {	
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		List<String> carNames;
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = convertArrToList(SCANNER.nextLine().split(","));
			InputException.checkValidCarNames(carNames);
			return carNames;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterCarNames();
		}
	}
	
	private static List<String> convertArrToList(String[] inputStringArr) {
		List<String> outputList = new ArrayList<String>();
		for (int i = 0; i < inputStringArr.length; i++) {
			InputException.checkOverlapping(outputList,inputStringArr[i].trim());
			outputList.add(inputStringArr[i].trim());
		}
		return outputList;
	}
	
	public static int enterRounds() {
		int rounds;
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			rounds = enterInt();
			InputException.checkValidRounds(rounds);
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
}