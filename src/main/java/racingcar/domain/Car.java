package racingcar.domain;

import racingcar.resource.rule.Delimiter;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.position++;
    }

    @Override
    public String toString() {
        return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(position));
    }

}
