package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class InputUtils {

    private static final int FIVE = 5;
    private static final String COMMA = ",";

    private InputUtils() {
    }

    public static boolean isNameLessThanFive(String names) {
        for (String name : names.split(COMMA)) {
            if (name.length() > FIVE) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLoopTimeInteger(String integer) {
        for (int i = 0; i < integer.length(); i++) {
            if (!Character.isDigit(integer.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
