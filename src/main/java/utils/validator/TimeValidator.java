package utils.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TimeValidator {
    private final String NUMBER_PATTERN = "^[0-9]*$";

    boolean isDigit(String number) {
        return Arrays.asList(number)
                .stream()
                .allMatch(time -> Pattern.matches(NUMBER_PATTERN, number));
    }
}
