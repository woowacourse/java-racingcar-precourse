package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	public static void printHead() {
		System.out.println("실행 결과");
	}

	public static void printScore(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printWinners(List<String> carNames) {
		System.out.print("최종 우승자 : ");
		System.out.print(carNames.get(0));
		if (carNames.size() == 1) {
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
}
