package racing.validator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static Pattern INTEGER_REGEX_PATTERN = Pattern.compile("^[1-9]$|^[1-9]\\d$");
    private static String INVALID_ROUND_MESSAGE = "2자리수 이하의 양의 정수 값을 입력해 주세요.";

    private static Pattern FIVE_LENGTH_NAME_REGEX_PATTERN = Pattern.compile("^[a-zA-Z]{1,5}$");
    private static String INVALID_NAME_MESSAGE = "5자리수 이하의 영단어로 입력해 주세요.";

    public static boolean isValidRound(String roundAsString) {
        boolean res = isValidPattern(roundAsString, INTEGER_REGEX_PATTERN);

        if (!res) {
            System.out.println(INVALID_ROUND_MESSAGE);
        }
        return res;
    }

    public static boolean isValidNames(String names) {
        String[] nameArray = names.split(",");
        boolean res = Arrays.stream(nameArray)
                .allMatch(name -> isValidPattern(name, FIVE_LENGTH_NAME_REGEX_PATTERN));

        if (!res) {
            System.out.println(INVALID_NAME_MESSAGE);
        }
        return res;
    }

    private static boolean isValidPattern(String value, Pattern pattern) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
