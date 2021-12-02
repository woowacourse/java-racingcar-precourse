package racingcar.domain;

import static racingcar.utils.RandomNumber.checkPassOrFail;

import java.util.Collections;

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
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    private void printPosition() {
        String curPosition = String.join("", Collections.nCopies(this.position, "-"));
        System.out.println(this.name + " : " + curPosition);
    }

    private void move() {
        this.position++;
    }
}
