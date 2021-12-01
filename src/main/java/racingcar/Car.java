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

    private void printPosition() {
        System.out.println(name + " : " + Collections.nCopies(position, "-"));
    }

    private void run() {
        this.position++;
    }
}
