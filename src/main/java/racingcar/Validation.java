package racingcar;

public class Validation {
    public static void isValidNames(String[] input) {
        if (!(isMoreThanZero(input) && isValidLength(input))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isMoreThanZero(String[] input) {
        if (input.length < 1) {
            System.out.println(Constant.ERROR_NO_NAMES);
            return false;
        }
        return true;
    }

    private static boolean isValidLength(String[] input) {
        for (String i : input) {
            if (i.length() > 5) {
                System.out.println(Constant.ERROR_MORE_THAN_FIVE_CHARACTERS);
                return false;
            }
        }
        return true;
    }
}
