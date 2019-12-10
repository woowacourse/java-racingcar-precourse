package view;

import java.util.stream.Collectors;

import domain.Car;
import domain.CarCollection;

public class OutputView {

	public static void showCarNamesInfo() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
	}

	public static void showTryCountInfo() {
		System.out.println("시도할 회수는 몇회 인가요?");
	}

	public static void showResultInfo() {
		System.out.println("실행 결과");
	}

	public static void showRacingProcess(CarCollection carCollection) {
		carCollection.getCarsPositionWithRacingFormat()
			.forEach(System.out::println);
		System.out.println();
	}

	public static void showRacingResultReport(CarCollection carCollection) {
		String winner = carCollection.getCarsWinner().stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.println(winner + "가 최종 우승했습니다.");
	}

}
