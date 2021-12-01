package racingcar.domain;

import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int PASS_VALUE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void playRound() {
        if (Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE) >= PASS_VALUE) {
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
