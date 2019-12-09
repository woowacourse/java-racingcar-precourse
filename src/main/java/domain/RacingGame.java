package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGame {
	public static Scanner sc = new Scanner(System.in);
	public static Car[] cars;

	public static void main(String[] args) {
		String names = inputNames();
		int rounds = inputRounds();
		cars = makeCars(names);

		System.out.println("실행 결과");
		for (int i = 0; i < rounds; i++) {
			for (int j = 0; j < cars.length; j++) {
				int energy = atRandom();
				cars[j].move(energy);
				cars[j].printPosition();
			}
			System.out.println();
		}

		if (sc != null) {
			sc.close();
		}
	}

	public static String inputNames() {
		String nameList = null;
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
		System.out.println("예시) pobi, crong, honux");

		nameList = sc.nextLine();
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

	public static Car[] makeCars(String names) {
		String[] nameList = names.split(",");
		int numberOfCars = nameList.length;
		Car[] cars = new Car[numberOfCars];

		for (int i = 0; i < numberOfCars; i++) {
			cars[i] = new Car(nameList[i].trim());
		}
		return cars;
	}

	public static int inputRounds() {
		int rounds = 0;
		boolean notEntered = true;
		System.out.println("\n시도할 회수는 몇 회인가요?");

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

	public static int atRandom() {
		return (int) (Math.random() * 10);
	}
}
