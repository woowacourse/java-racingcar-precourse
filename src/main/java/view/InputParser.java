package view;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static List<String> splitStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
