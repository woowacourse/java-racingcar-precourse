package racingcar;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NAMES_SPLIT_REGEX = ",";
	private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	private InputView() {
	}

	public static List<String> readCarNames() {
		System.out.println(NAMES_INPUT_MESSAGE);
		return tokenizeCarNames(Console.readLine());
	}

	private static List<String> tokenizeCarNames(String names) {
		String[] carNames = names.split(NAMES_SPLIT_REGEX);
		return Arrays.stream(carNames)
			.map(String::trim)
			.collect(toList());
	}

	public static int readTryCount() {
		System.out.println(TRY_COUNT_INPUT_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}
}
