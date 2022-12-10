package racingcar.message;

public enum Message {
    DELIMITER(","),
    INFIX(" : "),
    POSITION("-"),
    WINNER("최종 우승자 : "),
    LOSER(""),
    PRINT_INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PRINT_INPUT_FINAL_ROUND("시도할 회수는 몇회인가요?"),
    PRINT_OUTPUT("실행 결과");

    private String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
