package racingcar;

import racingcar.exception.ParticipantNameSizeOverException;
import java.util.InputMismatchException;

import static utils.TextResource.*;

public class ErrorLogger {
    private static final String PREFIX_ERROR = "[ERROR]";

    public static void printError(Exception e) {
        if (e instanceof ParticipantNameSizeOverException) {
            System.out.println(PREFIX_ERROR + STATEMENT_ERROR_CAR_NAME_SIZE_OVER);
            return;
        }

        if (e instanceof InputMismatchException) {
            System.out.println(PREFIX_ERROR + STATEMENT_ERROR_INPUT_NOT_VALID);
            return;
        }

        System.out.println(STATEMENT_ERROR_DEFAULT);
    }
}
