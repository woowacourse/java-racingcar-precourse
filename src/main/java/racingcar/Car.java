package racingcar;

import racingcar.util.Assertions;

public class Car {
    private static final int NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        Assertions.throwExceptionIsTrue(name.length() > NAME_LENGTH, ErrorInfo.LENGTH);
        this.name = name;
    }

}
