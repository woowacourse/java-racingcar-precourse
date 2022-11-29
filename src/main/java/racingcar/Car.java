package racingcar;

import static racingcar.ErrorCode.NOT_VALID_CAR_NAME;

public class Car {
    private static final int nameLength = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void validateCarName(String name) {
        if(name.length()> nameLength) {
            NOT_VALID_CAR_NAME.throwError();
        }
    }
    // 추가 기능 구현
}
