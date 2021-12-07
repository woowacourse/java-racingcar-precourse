package racingcar.common.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {
	private static final String DELIMITER = ",";
	private static final String DASH = "-";
	public static final String JOIN_DELIMITER = ", ";

	public static List<String> split(final String carName) {
		return Arrays.stream(carName.split(DELIMITER)).map(String::trim)
			.collect(Collectors.toList());
	}

	public static String convertIntoDashBy(final int position) {
		return Stream.generate(() -> DASH).limit(position)
			.collect(Collectors.joining());
	}

	public static String joinNameOf(final List<String> winners) {
		return String.join(JOIN_DELIMITER, winners);
	}

}
