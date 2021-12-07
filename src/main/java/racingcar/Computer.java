package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자와 소통(질문하고 입력받기)하는 역할을 수행하는 Class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class Computer {
	private static final char POSITION_CHAR = '-';
	private static final String ERROR_HEADER = "[ERROR]";

	public static String[] askCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		return carNames.split(",");
	}

	public static String askHowManyTimes() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}

	public static void printCarPosition(Car car) {
		StringBuilder strPosition = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			strPosition.append(POSITION_CHAR);
		}
		System.out.printf("%s : %s%n", car.getName(), strPosition);
	}

	public static void printWinner(ArrayList<Car> winnerList) {
		StringBuilder winnerNames = new StringBuilder();
		for (Car car : winnerList) {
			winnerNames.append(car.getName());
			winnerNames.append(", ");
		}
		winnerNames.deleteCharAt(winnerNames.lastIndexOf(", "));
		System.out.printf("최종 우승자 : %s", winnerNames);
	}

	public static void printError(Exception e) {
		System.out.printf("%s %s%n", ERROR_HEADER, e.getMessage());
	}
}
