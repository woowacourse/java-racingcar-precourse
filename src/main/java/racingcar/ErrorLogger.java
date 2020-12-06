package racingcar;

import racingcar.exception.ParticipantNameException;
import java.util.InputMismatchException;

import static utils.TextResource.*;

public class ErrorLogger {
    public static final String PREFIX_ERROR = "[ERROR]";

    public static void printError(Exception e) {
        if (e instanceof ParticipantNameException) {
            ((ParticipantNameException) e).printError();
            return;
        }

        if (e instanceof InputMismatchException) {
            System.out.println(PREFIX_ERROR + STATEMENT_ERROR_INPUT_NOT_VALID);
            return;
        }

        System.out.println(STATEMENT_ERROR_DEFAULT);
    }
}
