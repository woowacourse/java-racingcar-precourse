package racingcar;

public class MessageUtils {

    public static void errorExceptionThrow(String messageConstant) {
        System.out.println(Constants.ERROR_HEADER + messageConstant);
        throw new IllegalArgumentException(Constants.ERROR_HEADER + messageConstant);
    }

    public static void printMessageWithConstant(String[] messages) {
        String printMessages = "";
        for (String message : messages) {
            printMessages += message;
        }
        printMessages += "\n";
        System.out.printf(printMessages);
    }

}
