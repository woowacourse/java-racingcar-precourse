package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	private static final List<String> winners = new ArrayList<>();

	public static void setAmong(List<Car> cars) {
		for (Car car : cars) {
			if (car.isWinner()) {
				winners.add(car.getName());
			}
		}
	}

	public static void print() {
		String resultMessage = makeMessage();
		System.out.println(resultMessage);
	}

	private static String makeMessage() {
		StringBuilder builder = new StringBuilder("최종 우승자 : ");
		builder.append(winners.get(0));
		for (int i = 1; i < winners.size(); i++) {
			builder.append(", ").append(winners.get(i));
		}
		return builder.toString();
	}
}
