package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private StringConverter() {
    }

    public static List<String> toListSplitByComma(String origin) {
        return Arrays.stream(origin.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
