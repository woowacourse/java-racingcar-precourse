package racingcar;

public class MessageUtils {

    public static void printMessageWithConstant(String[] messages) {
        String printMessages = "";
        for (String message : messages) {
            printMessages += message;
        }
        System.out.println(printMessages);
    }

}
