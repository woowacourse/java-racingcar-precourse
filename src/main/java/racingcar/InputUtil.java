package racingcar;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
	private static final String LIST_SPLIT_DELIMITER = ",";
	private static final String NOT_INT_ERROR = "[ERROR] 반드시 숫자를 입력해야 합니다.";

	private InputUtil() {
	}

	public static List<String> readStringList() {
		String rawStr = readLine();
		return toStringList(rawStr);
	}

	private static String readLine() {
		return Console.readLine();
	}

	private static List<String> toStringList(String names) {
		String[] tokens = names.split(LIST_SPLIT_DELIMITER);
		return Arrays.stream(tokens)
			.map(String::trim)
			.collect(toList());
	}

	public static int readInt() {
		try {
			return Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			OutputView.printErrorMessage(NOT_INT_ERROR);
			return readInt();
		}
	}
}
