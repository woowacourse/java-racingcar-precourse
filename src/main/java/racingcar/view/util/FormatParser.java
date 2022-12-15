package racingcar.view.util;

import static racingcar.view.constants.Format.INPUT_NAMES_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.constants.ErrorMessage;

public class FormatParser {
    private FormatParser() {
    }

    public static List<String> split(String line, String delimiter) {
        validateWrongFormat(line);
        String[] values = line.split(delimiter);
        List<String> parsedValue = Arrays.stream(values)
                .map(String::trim)
                .collect(Collectors.toList());
        validateEmpty(parsedValue);
        return parsedValue;
    }

    private static void validateWrongFormat(String line) {
        if (hasWrongFormat(line)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_INVALID);
        }
    }

    private static boolean hasWrongFormat(String line) {
        if (line.isEmpty()) {
            return true;
        }
        return line.startsWith(INPUT_NAMES_DELIMITER) || line.endsWith(INPUT_NAMES_DELIMITER);
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

    public static String join(List<String> values, String delimiter) {
        return String.join(delimiter, values);
    }

    public static String make(int count, String unit) {
        return unit.repeat(count);
    }
}
