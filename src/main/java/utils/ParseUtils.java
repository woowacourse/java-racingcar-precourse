package utils;

import java.util.Arrays;
import java.util.List;

public class ParseUtils {
    private static final String DELIMITER_COMMA = ",";

    public static List<String> parseStringToStringList(String input) {
        return Arrays.asList(splitStringByComma(input));
    }

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] splitStringByComma(String input) {
        return input.split(DELIMITER_COMMA);
    }
}