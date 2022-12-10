package racingcar.message;

public enum Message {
    DELIMITER(","),
    INFIX(" : "),
    POSITION("-");
    private String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
