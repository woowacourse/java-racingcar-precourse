package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class OutputView {

	public static void showSentenceBeforeResult() {
		System.out.println("\n실행 결과");
	}

	public static void showResultThisTiming(ArrayList<Car> cars) {
		cars.forEach(eachCar -> System.out.printf("%s : %s\n", eachCar.getName(), showMovingMark(eachCar)));
		System.out.println();
	}

	private static String showMovingMark(Car car) {
		StringBuffer movingMark = new StringBuffer();
		for (int i = 0; i < car.showMovingDistance(); i++) {
			movingMark.append("-");
		}
		return movingMark.toString();
	}

	public static void showThisGameWinner(List<String> winningCarsName) {
		StringBuffer result = new StringBuffer("최종 우승자 : ");
		result.append(String.join(", ", winningCarsName));
		System.out.println(result);
	}
}
