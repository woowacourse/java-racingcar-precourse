package racingcar;

public class Constants {

    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static final int MIN_ATTEMPT = 1;
    public static final int MAX_ATTEMPT = 1_000_000_000;

    // 사용자 입력 문자열을 배열로 나누기 위해 .split 함수에 사용할 문자열
    public static final String DIVIDER_FOR_SPLIT = ",";

    private Constants() {
    }
}
