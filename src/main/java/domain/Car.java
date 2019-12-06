package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void proceed() {
        this.position++;
    }
}