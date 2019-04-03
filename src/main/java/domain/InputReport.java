package domain;

public class InputReport {
    private int code = InputReportCode.NO_ERROR;
    private String errorMessage = InputReportMessage.NO_ERROR_MESSAGE;

    public void set(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int showCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}
