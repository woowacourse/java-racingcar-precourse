package racingcar.domain;

import racingcar.utils.OutputFormatter;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position++;
    }

    public String getCarStatus() {
        return OutputFormatter.converseCarStatus(position, name);
    }
}
