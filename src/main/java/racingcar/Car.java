package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements ICar {
    private final String name;
    private int position = 0;
    private ArrayList<String> trace;

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

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<String> getTrace() {
        return trace;
    }

    private void incrementPosition() {
        position ++;
    }

    private void recordPosition() {
        String result = name + " : ";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        trace.add(result);
    }
}
