package racingcar.domain.setting;

public enum Message {

    INPUT_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    , INPUT_REPEAT_MESSAGE("시도할 회수는 몇회인가요?")
    , RESULT_MESSAGE("실행 결과 \n")
    , WINNER_MESSAGE("최종 우승자: ")
    , POSITION_MARK("-")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.message;
    }


}
