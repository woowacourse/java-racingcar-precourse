package racingcar;

public class MessageUtils {

    public static void errorExceptionThrow(String messageConstant) {
        System.out.println(Constants.ERROR_HEADER + messageConstant);
        throw new IllegalArgumentException(Constants.ERROR_HEADER + messageConstant);
    }

}
