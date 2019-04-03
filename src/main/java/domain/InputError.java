package domain;

public class InputError {
    private int code = InputErrorCode.NO_ERROR;
    private String errorMessage = InputErrorMessage.NO_ERROR_MESSAGE;

    void setCode(int code) {
        this.code = code;
    }

    void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
