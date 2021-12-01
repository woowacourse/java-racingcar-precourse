package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void play() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.run();
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

    private void run() {
        this.position++;
    }
}
