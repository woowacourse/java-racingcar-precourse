package racingcar;

public class ExceptionUtils {

    public static void errorThrow(String messageConstant) {
        MessageUtils
            .printMessageWithConstant(new String[]{Constants.ERROR_PREFIX, messageConstant});
        throw new IllegalArgumentException(Constants.ERROR_PREFIX + messageConstant);
    }
}
