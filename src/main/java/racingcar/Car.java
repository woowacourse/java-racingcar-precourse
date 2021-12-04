package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        int number = rollTheDice();
        if (number >= 4) {
            run();
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int rollTheDice() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void run() {
        this.position++;
    }

}
