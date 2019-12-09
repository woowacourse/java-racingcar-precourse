package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGame {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		System.out.println("예시) pobi, crong, honux");
		String names = inputNames();
		System.out.println("\n시도할 회수는 몇 회인가요?");
		int rounds = inputRounds();
		if (sc != null) {
			sc.close();
		}
	}

	public static String inputNames() {
		String nameList = sc.nextLine();
		while (!validate(nameList)) {
			nameList = sc.nextLine();
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

	public static int inputRounds() {
		int rounds = 0;
		boolean notEntered = true;

		while (notEntered) {
			try {
				rounds = sc.nextInt();
				notEntered = false;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("라운드 입력 형식이 잘못되었습니다. 숫자를 다시 입력해주세요.");
			}
		}
		return rounds;
	}
}
