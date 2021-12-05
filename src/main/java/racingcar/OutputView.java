package racingcar;

import java.util.stream.Collectors;

public class OutputView {
	public void printResult(Cars cars, int numberOfAttempts) {
		System.out.println("실행 결과");
		for (int i = 0; i < numberOfAttempts; i++) {
			cars.controlByRandomNumber();
			printResultByAttempt(cars);
		}
	}

	public void printWinners(Cars cars) {
		System.out.println("최종 우승자 : " + getWinnersToString(cars));
	}

	private String getWinnersToString(Cars cars) {
		return cars.getWinners().stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}

	private void printResultByAttempt(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.println(car.getName() + " : " + changePositionToDash(car.getPosition()));
		}
		System.out.println();
	}

	private String changePositionToDash(int position) {
		StringBuilder dash = new StringBuilder();
		for (int i = 0; i < position; i++) {
			dash.append("-");
		}
		return dash.toString();
	}
}
