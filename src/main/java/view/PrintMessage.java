package view;

import domain.Car;

public class PrintMessage {
	private static boolean commaFlag = false;

	public static void inputName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void inputRound() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void printCar(Car[] car) {
		for (int i = 0; i < car.length; i++) {
			car[i].printCarStatus();
		}
		System.out.println();
	}

	public static void printResult(Car[] car, int maximumPosition) {
		for (int i = 0; i < car.length; i++) {
			printWinnerCarName(car[i], maximumPosition);
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private static void printWinnerCarName(Car car, int maximumPosition) {
		if (car.getPosition() == maximumPosition && commaFlag == false) {
			System.out.print(car.getName());
			commaFlag = true;
			return;
		}
		if (car.getPosition() == maximumPosition && commaFlag == true) {
			System.out.print("," + car.getName());
			return;
		}
	}
}
