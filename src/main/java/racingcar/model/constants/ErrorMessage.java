package racingcar.model.constants;

public class ErrorMessage {
    public static final String CARS_LACK_OF_COUNT = "경주할 자동차는 최소 2대 필요합니다.";
    public static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 최대 5글자까지만 가능합니다.";
    public static final String CARS_DUPLICATED_NAME = "중복된 자동차 이름을 등록할 수 없습니다.";
    
    private ErrorMessage() {
    }
}
