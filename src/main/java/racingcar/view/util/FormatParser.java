package racingcar.view.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.view.constants.ErrorMessage;

public class FormatParser {
    private FormatParser() {
    }

    public static List<String> split(String line, String delimiter) {
        String[] values = line.split(delimiter);
        List<String> parsedValue = Arrays.stream(values)
                .map(String::trim)
                .collect(Collectors.toList());
        validateEmpty(parsedValue);
        return parsedValue;
    }

    public static String join(List<String> values, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        values.forEach(joiner::add);
        return joiner.toString();
    }

    public static String make(int count, String unit) {
        return unit.repeat(count);
    }

    private static void validateEmpty(List<String> values) {
        if (hasEmptyValue(values)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_EMPTY);
        }
    }

    private static boolean hasEmptyValue(List<String> values) {
        return values.stream()
                .anyMatch(String::isEmpty);
    }
}
