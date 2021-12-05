package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
	private static final String GET_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String GET_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	public static String generateUserInput() {
		String userInput;
		userInput = readLine();

		return userInput;
	}

	public static void printStartMessage() {
		System.out.println(GET_CARS_MESSAGE);
	}

	public static void printGetCountMessage() {
		System.out.println(GET_COUNT_MESSAGE);
	}

	public static List<String> strToList(String str) {
		String[] strSplited = str.split(",");
		List<String> list;
		list = new ArrayList<>(Arrays.asList(strSplited));

		return list;
	}
}
