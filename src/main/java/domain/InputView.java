/*
 * InputView.java
 */

package domain;

import java.util.List;
import java.util.Scanner;

class InputView {

	public static List<Car> getCarsList() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분)");
			try {
				return Parser.strToListOfCar(getInput());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int getGameCount() {
		while (true) {
			System.out.println("시도할 회수는 몇 회인가요?");
			try {
				return Parser.strToInt(getInput());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
