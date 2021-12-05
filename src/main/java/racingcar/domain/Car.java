package racingcar.domain;

import racingcar.utils.Delimiter;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.position++;
    }

    public boolean isFatherThan(int position) {
        return (this.position > position);
    }

    public boolean isSamePosition(int position) {
        return (this.position == position);
    }

    @Override
    public String toString() {
        return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(position));
    }

}
