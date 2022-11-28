package racingcar.utils;

import java.util.Objects;

public class StringUtils {
    public static boolean isBlank(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
