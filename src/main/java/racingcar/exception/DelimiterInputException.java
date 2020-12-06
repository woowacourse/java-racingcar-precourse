package racingcar.exception;

public class DelimiterInputException extends  RacingCarException{
    private static final String DEFAULT_MESSAGE = "[ERROR] 구분 기호는 (,)이며, 적어도 1개 이상 입력해야 한다.";

    public DelimiterInputException() {
        super(DEFAULT_MESSAGE);
    }
}
