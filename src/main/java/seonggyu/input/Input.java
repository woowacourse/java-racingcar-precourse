package seonggyu.input;

import java.util.Scanner;
import java.util.List;

public class Input {	
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		List<String> carNames;
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = InputParsing.parseArrToList(SCANNER.nextLine().split(","));
			InputException.checkValidCarNames(carNames);
			return carNames;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterCarNames();
		}
	}
	
	public static int enterRounds() {
		int rounds;
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			rounds = InputParsing.parseStringToInt(SCANNER.nextLine());
			InputException.checkValidRounds(rounds);
			return rounds;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterRounds();
		}
	}
}