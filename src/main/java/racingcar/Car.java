package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.ErrorCode.NOT_VALID_CAR_NAME;

public class Car {
    private static final int NAME_LENGTH = 5;
    private static final int MOVING_MIN = 0;
    private static final int MOVING_MAX = 9;
    private static final int MOVING_RULE = 4;
    private static final String MOVING_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void validateCarName(String name) {
        if(name.length()> NAME_LENGTH) {
            NOT_VALID_CAR_NAME.throwError();
        }
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MOVING_MIN, MOVING_MAX);

        if(randomNumber >= MOVING_RULE) {
            position++;
        }
    }

    public String getPosition() {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i<position; i++) {
            sb.append(MOVING_SYMBOL);
        }

        return sb.toString();
    }
    // 추가 기능 구현
}
