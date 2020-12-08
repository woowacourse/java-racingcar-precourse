package racingcar.exception;

import static racingcar.ErrorLogger.PREFIX_ERROR;
import static utils.TextResource.STATEMENT_ERROR_CAR_NAME_SIZE_OVER;

public class ParticipantNameException extends Exception {
    public static final int ERROR_CODE_NAME_SIZE_OVER = 0;

    private int errorCode = 0;

    public ParticipantNameException(int code) {
        this.errorCode = code;
    }

    public int getCode() {
        return errorCode;
    }

    public void printError() {
        if (errorCode == ERROR_CODE_NAME_SIZE_OVER) {
            System.out.println(PREFIX_ERROR + STATEMENT_ERROR_CAR_NAME_SIZE_OVER);
            return;
        }
    }
}
