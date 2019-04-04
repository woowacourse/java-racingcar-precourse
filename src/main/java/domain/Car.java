package domain;

import interfaces.CarInterface;

public class Car implements CarInterface {
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameSize(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int result) {
        if (result == 1) {
            position++;
        }
    }

    private void checkNameSize(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE + name);
        }
    }
}
