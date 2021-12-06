package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	private static final int SOLO = 1;

	public static void printHead() {
		System.out.println("실행 결과");
	}

	public static void printScore(List<Car> cars) {
		for (Car car : cars) {
			printCarScore(car);
		}
		System.out.println();
	}

	public static void printWinners(List<String> carNames) {
		System.out.print("최종 우승자 : ");
		System.out.print(carNames.get(0));
		if (checkSoloWin(carNames)) {
			System.out.println();
			return;
		}
		for (int i = 1; i < carNames.size(); i++) {
			System.out.print(", ");
			System.out.print(carNames.get(i));
		}
		System.out.println();
	}

	public static void printException(String message) {
		System.out.println(message);
	}

	private static void printCarScore(Car car) {
		System.out.print(car.getName() + " : ");
		printPosition(car);
		System.out.println();
	}

	private static void printPosition(Car car) {
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
	}

	private static boolean checkSoloWin(List<String> carNames) {
		return carNames.size() == SOLO;
	}
}
