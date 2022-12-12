package racingcar.util;

public class Util {

    public static final String BAR = "-";

    public static int convertStringToInt(String input) {
        try {
            long longValue = Long.parseLong(input);
            Validator.validateNumberValue(longValue);
            return (int) longValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다");
        }
    }

    public static String convertPositionToBar(int position) {
        return BAR.repeat(position);
    }

}


