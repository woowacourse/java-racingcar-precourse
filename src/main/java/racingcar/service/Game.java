package racingcar.service;

import static racingcar.message.GuideMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;

public class Game {

	public static void start(String[] nameList, int trials) {
		Car[] carList = NamingProcess.StringToArray(nameList);

		System.out.println(RESULT_MESSAGE);

		while (trials-- > 0) {
			rollTheDice(carList);
		}

		printResult(carList);
	}

	private static void rollTheDice(Car[] carList) {
		for (Car car : carList) {
			StringBuilder builder = new StringBuilder();
			builder.append(car.getName()).append(" : ");

			RandomProcess.moveOrStand(car);

			appendPosition(builder, car.getPosition());
			System.out.println(builder);
		}
		System.out.println();
	}

	private static void appendPosition(StringBuilder builder, int position) {
		for (int i = 0; i < position; i++) {
			builder.append("-");
		}
	}

	private static void printResult(Car[] carList) {
		int max = getMax(carList);

		List<String> nameList = getWinnerList(carList, max);

		System.out.println(makeResultMessage(nameList));
	}

	private static int getMax(Car[] carList) {
		return Arrays.stream(carList)
			.mapToInt(car -> car.getPosition())
			.max()
			.getAsInt();
	}

	private static List<String> getWinnerList(Car[] carList, int max) {
		List<String> list = new ArrayList<>();

		Arrays.stream(carList)
			.filter(car -> car.getPosition() == max)
			.forEach(car -> list.add(car.getName()));

		return list;
	}

	private static String makeResultMessage(List<String> nameList) {
		StringBuilder builder = new StringBuilder(FINAL_WINNER);
		builder.append(nameList.get(0));
		for (int i = 1; i < nameList.size(); i++) {
			builder.append(", ").append(nameList.get(i));
		}
		return builder.toString();
	}
}
