package view;

import domain.Car;

public class PrintMessage {
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
}
