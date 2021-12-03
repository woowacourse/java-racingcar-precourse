package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void isNameOutOfRange(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void isNameNull(String carName) throws IllegalArgumentException {
        if (carName.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
