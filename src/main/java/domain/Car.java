package domain;

import static constants.CarConstants.*;

public class Car {
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

    public void move(boolean result) {
        if (result) {
            position++;
        }
    }

    private void checkNameSize(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE + name);
        }
    }
}
