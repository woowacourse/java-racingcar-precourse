package racingcar.domain;

import java.util.Collections;

import static racingcar.utils.RandomNumber.checkPassOrFail;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void playRound() {
        if (checkPassOrFail()) {
            this.move();
        }
        this.printPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void printPosition() {
        String curPosition = String.join("", Collections.nCopies(position, "-"));
        System.out.println(name + " : " + curPosition);
    }

    private void move() {
        this.position++;
    }
}
