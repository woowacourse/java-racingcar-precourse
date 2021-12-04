package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements ICar {
    private final String name;
    private int position = 0;
    private ArrayList<Integer> trace;

    public Car(String name) {
        this.name = name;
        this.trace = new ArrayList<>();
    }

    @Override
    public void pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            incrementPosition();
        }
        recordPosition();
    }

    private void incrementPosition() {
        position ++;
    }

    private void recordPosition() {
        trace.add(position);
    }
}
