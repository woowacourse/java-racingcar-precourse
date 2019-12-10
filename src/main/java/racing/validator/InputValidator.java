package racing.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static Pattern INTEGER_REGEX_Pattern = Pattern.compile("^[1-9]$|^[1-9]\\d$");
    private static String INVALID_ROUND_MESSAGE = "2자리수 이하의 양의 정수 값을 입력해 주세요.";

    public static boolean isValidRound(String roundAsString) {
        boolean res = isValidRoundType(roundAsString);

        if (!res) {
            System.out.println(INVALID_ROUND_MESSAGE);
        }
        return res;
    }

    private static boolean isValidRoundType(String roundValue) {
        Matcher matcher = INTEGER_REGEX_Pattern.matcher(roundValue);
        return matcher.matches();
    }
}
