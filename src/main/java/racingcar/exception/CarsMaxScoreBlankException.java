package racingcar.exception;

public class CarsMaxScoreBlankException extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_CARS_MAX_SCORE_BLANK = "[ERROR] 우승자를 찾을 수 없습니다.";

    public CarsMaxScoreBlankException() {
        super(EXCEPTION_MESSAGE_CARS_MAX_SCORE_BLANK);
    }
}
