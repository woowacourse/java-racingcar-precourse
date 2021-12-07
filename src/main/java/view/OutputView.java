package view;

import java.util.List;

import racingcar.Car;

public class OutputView {
	private static final String FORWARD_MARK = "-";
	private static final int ZERO = 0;

	private OutputView() {
	}

	public static void printCarsPositionStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + carPositionToString(car));
		}
		printLineBreak();
	}

	private static String carPositionToString(Car car) {
		int position = car.getPosition();
		StringBuilder positionStringBuilder = new StringBuilder();
		while (position > ZERO) {
			positionStringBuilder.append(FORWARD_MARK);
			position--;
		}
		return positionStringBuilder.toString();
	}

	public static void printGameWinner(List<String> winnerList) {
		System.out.print("최종 우승자 : ");
		System.out.println(winnerList.toString()
			.replace("[", "")
			.replace("]", ""));
	}

	public static void printCarNamesInputMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void printMoveTimesInputMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void printGameResultMessage() {
		printLineBreak();
		System.out.println("실행 결과");
	}

	public static void printCarNameLengthExceptionMessage() {
		System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
	}

	public static void printCarNameDuplicationExceptionMessage() {
		System.out.println("[ERROR] 자동차 이름은 중복될 수 없습니다.");
	}

	public static void printMoveTimesTypeExceptionMessage() {
		System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
	}

	public static void printMoveTimesNegativeExceptionMessage() {
		System.out.println("[ERROR] 시도 횟수는 양수여야 합니다.");
	}

	public static void printLineBreak() {
		System.out.println();
	}
}
