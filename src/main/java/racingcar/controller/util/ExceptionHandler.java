package racingcar.controller.util;

import java.util.function.Consumer;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static void retryForIllegalArgument(Runnable runnable, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }
}
