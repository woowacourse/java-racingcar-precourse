package racingcar;

import static utils.RandomUtils.nextInt;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void ride() {
        final int THRESHOLD = 4;

        int randomNumber = nextInt(0, 9);
        if (randomNumber >= THRESHOLD) {
            position++;
        }
    }
}
