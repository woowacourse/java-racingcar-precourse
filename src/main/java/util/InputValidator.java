package util;

public class InputValidator {

    public static boolean isNumberInRange(String input, int min) {
        try {
            int inputNumber = Integer.parseInt(input);
            return inputNumber >= min;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}