package utils;

import racingcar.Messages;

public class PrintUtils {

    private PrintUtils() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(Messages.MESSAGE_ERROR + message);
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
