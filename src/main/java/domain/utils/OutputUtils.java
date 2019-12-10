/**
 * 프로젝트의 출력을 담당하는 클래스
 *
 * @author	MinKyu,Song
 * @version	12/10/2019
 */

package domain.utils;

import java.util.List;

import domain.Car;

public final class OutputUtils {
	private static final String PROGRESS_BAR = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private OutputUtils() {}

	public static void printCarProgress(Car car) {
		String message = car.getName() + " : "
			+ new String(new char[car.getPosition()]).replace("\0", PROGRESS_BAR);
		System.out.println(message);
	}

	public static void printWinner(List<String> winners) {
		String message = String.join(", ", winners) + WINNER_MESSAGE;
		System.out.println(message);
	}
}
