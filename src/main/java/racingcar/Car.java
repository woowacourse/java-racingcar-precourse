package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        CarValidator.validateCarName(name);
        this.name = name;
    }
}
