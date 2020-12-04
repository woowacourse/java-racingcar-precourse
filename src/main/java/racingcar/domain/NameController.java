package racingcar.domain;

import com.sun.tools.javac.util.StringUtils;

public class NameController {
    private static final int MAX_LEN_OF_NAME = 5;
    private static final int MIN_LEN_OF_NAME = 1;
    private static final int DIFFERENCE_BETWEEN_NAMES_AND_COMMAS = 1;

    private NameController() {

    }

    public static String[] splitNameByComma(String name) {
        String[] names = name.split(",");
        return names;
    }

    private static int getNumberOfCommas(String name) {
        return Long.valueOf(name.chars().filter(ch -> ch == ',').count()).intValue();
    }

    private static int getNumberOfName(String[] name) {
        return name.length;
    }

    public static boolean compareCountBetweenCommaAndName(String nameContainsComma, String[] names) {
        int numberOfCommas = getNumberOfCommas(nameContainsComma);
        int numberOfNames = getNumberOfName(names);
        return (numberOfCommas + DIFFERENCE_BETWEEN_NAMES_AND_COMMAS) == numberOfNames;
    }

    public static boolean isEmptyString(String[] name) {
        if (name.length < MIN_LEN_OF_NAME) {
            return false;
        }
        return true;
    }

    public static boolean checkLengthOfEachName(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_LEN_OF_NAME || name.length() < MIN_LEN_OF_NAME) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicatedName(String[] names) {
        for (int i = 1; i < names.length; i++) {
            if (names[i - 1].equals(names[i])) {
                return false;
            }
        }
        return true;
    }
}
