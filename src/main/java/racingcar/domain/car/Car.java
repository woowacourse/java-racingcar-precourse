package racingcar.domain.car;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH_LIMIT = 5;
    private static final String CAR_NAME_LENGTH_OVER_MESSAGE = "[ERROR] 자동차의 이름은 5글자 이하만 가능합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCar(name);
        this.name = name;
    }

    private void validateCar(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_MESSAGE);
        }
    }
}
