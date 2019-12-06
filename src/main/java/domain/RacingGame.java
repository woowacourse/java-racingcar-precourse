package domain;

import java.util.Scanner;

public class RacingGame {
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		System.out.println("예시) pobi, crong, honux");
		String names = inputNames();
	}

	public static String inputNames() {
		Scanner scanner = null;
		String nameList = "";

		try {
			scanner = new Scanner(System.in);
			nameList = scanner.nextLine();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return nameList;
	}
}
