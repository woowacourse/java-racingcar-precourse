package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParsing {
	public static List<String> makeNumbersFromString(String nameList) {
		return Arrays.asList(nameList.split(",")).stream()
			.map(String::trim)
			.collect(Collectors.toList());
	}
}
