package racingcar.message;

public enum ErrorMessage {
    CAR_NAME_TOO_LONG("차 이름은 5글자 이내여야합니다.");
    private final String prefix = "[ERROR]";
    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return prefix + message;
    }
}
