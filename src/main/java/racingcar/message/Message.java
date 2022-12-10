package racingcar.message;

public enum Message {
    DELIMITER(","),
    INFIX(" : ");
    private String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
