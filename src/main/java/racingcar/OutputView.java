package racingcar;

public class OutputView {
	public void printResult(Cars cars, int numberOfAttempts) {
		System.out.println("실행 결과");
		for (int i = 0; i < numberOfAttempts; i++) {
			cars.controlByRandomNumber();
			printResultByAttempt(cars);
		}
	}

	private void printResultByAttempt(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.println(car.getName() + " : " + changePositionToDash(car.getPosition()));
		}
		System.out.println();
	}

	private String changePositionToDash(int position) {
		StringBuffer dash = new StringBuffer();
		for (int i = 0; i < position; i++) {
			dash.append("-");
		}
		return dash.toString();
	}
}
