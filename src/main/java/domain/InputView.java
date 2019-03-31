/*
 * InputView.java
 */

package domain;

import java.util.List;
import java.util.Scanner;

class InputView {
	private static final int NAME_MAX = 5;

	public static List<Car> getCarsList() {
		List<Car> carList = null;
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분");
			carList = Parser.stringToListOfCar(getInput());
			if (checkValidCarList(carList)) {
				break;
			}
			System.out.println("5자 이하의 자동차 이름을 입력하세요.");
		}
		return carList;
	}

	private static boolean checkValidCarList(List<Car> carList) {
		for (Car car : carList) {
			if (car.getName().length() > NAME_MAX) {
				return false;
			}
		}
		return true;
	}

	public static int getGameCount() {
		System.out.println("시도할 회수는 몇 회인가요?");
		return Parser.stringToInt(getInput());
	}

	private static String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
