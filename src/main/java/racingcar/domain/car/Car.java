package racingcar.domain.car;

public class Car {

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        isCorrectLength(name);
    }

    private void isCorrectLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT || name.isEmpty()) {
            throw new CarNameLengthMustBetweenOneToFive();
        }
    }
}
