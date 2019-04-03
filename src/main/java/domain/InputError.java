package domain;

public class InputError {
    private int code = InputErrorCode.NO_ERROR;
    private String errorMessage = InputErrorMessage.NO_ERROR_MESSAGE;

    public void set(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}
