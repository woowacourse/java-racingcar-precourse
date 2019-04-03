package domain;

public class InputReport {
    private int code = InputReportCode.NO_ERROR;
    private String message = InputReportMessage.NO_ERROR_MESSAGE;

    public void set(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int showCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
