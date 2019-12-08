package domain.utils;

import java.util.List;

import domain.Car;

public class OutputUtils {
	private static final String PROGRESS_BAR = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static void printCarProgess(Car car) {
		String message = car.getName() + " : " + new String(new char[car.getPosition()]).replace("\0", PROGRESS_BAR);
		System.out.println(message);
	}

	public static void printWinner(List<String> winners) {
		String message = String.join(", ", winners) + WINNER_MESSAGE;
		System.out.println(message);
	}
}
