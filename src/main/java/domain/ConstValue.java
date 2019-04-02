package domain;

public class ConstValue {

    /* 자동차 시작 지점 */
    public static final int START_POSITION = 0;

    /* 전진 시 한번에 이동하는 거리 */
    public static final int MOVE_DISTANCE = 1;

    /* move 와 stop 을 결정하는 기준 */
    public static final int ACTION_DECISION_VALUE = 4;

    /**
     * 랜덤으로 생성되는 수의 범위
     * 0 ~ (RANDOM_NUMBER_RANGE - 1)
     */
    public static final int RANDOM_NUMBER_RANGE = 10;

    /* max position 을 구하기 위해 초기값 설정용 */
    public static final int MINIMUM_DISTANCE_VALUE = -1;
}
