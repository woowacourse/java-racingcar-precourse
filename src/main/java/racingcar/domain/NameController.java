package racingcar.domain;

public class NameController {
    private final static int MAX_LEN_OF_NAME = 5;
    private final static int MIN_LEN_OF_NAME = 1;

    private NameController() {

    }

    public static String[] splitNamebyComma(String name) {
        String[] names = name.split(",");
        return names;
    }

    public static boolean checkLengthOfName(String[] names) {
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
