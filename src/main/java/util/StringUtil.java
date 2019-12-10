package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String DELIMITER = ",";
    private static final String DISTANCE_SYMBOL = "-";

    public static List<String> getListFromString(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static String getPositionSymbol(int position, String symbol) {
        return symbol.repeat(position);
    }

    public static List<String> removeBlank(List<String> names) {
        return names.stream().filter(name -> !name.isBlank()).collect(Collectors.toList());
    }
}
