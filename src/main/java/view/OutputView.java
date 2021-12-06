package view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.Car;

public class OutputView {
	private static final String FORWARD_MARK = "-";
	private static final int ZERO = 0;

	public static void printCarsPositionStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + carPositionToString(car));
		}
		System.out.println();
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

	public static void printGameWinner(List<Car> carList) {
		Set<String> winnerNameSet = searchGameWinners(carList);
		System.out.print("최종 우승자 : ");
		System.out.println(winnerNameSet.toString()
			.replace("[", "")
			.replace("]", ""));
	}

	private static Set<String> searchGameWinners(List<Car> carList) {
		Set<String> winnerNameSet = new HashSet<>();
		int winnerPosition = 0;
		for (Car car : carList) {
			if (car.getPosition() > winnerPosition) {
				winnerPosition = car.getPosition();
				winnerNameSet.clear();
				winnerNameSet.add(car.getName());
			}
			if (car.getPosition() == winnerPosition) {
				winnerNameSet.add(car.getName());
			}
		}
		return winnerNameSet;
	}

	public static void printCarNamesInputMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void printMoveTimesInputMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void printGameResultMessage() {
		System.out.println("\n실행 결과");
	}

	public static void printCarNameLengthExceptionMessage() {
		System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
	}

	public static void printMoveTimesExceptionMessage() {
		System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
	}

	public static void printLineBreak() {
		System.out.println();
	}
}
