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
			while (!validate(nameList)) {
				nameList = scanner.nextLine();
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return nameList;
	}

	public static boolean validate(String nameList) {
		String[] names = nameList.split(",", -1);
		int length = names.length;

		for (int i = 0; i < length; i++) {
			String name = names[i].trim();
			if ((name.equals("")) || (name.length() > 5)) {
				System.out.println("이름 입력형식이 잘못되었습니다. 다시 입력해주세요.");
				System.out.println("예시) pobi, crong, honux");
				return false;
			}
		}
		return true;
	}
}
