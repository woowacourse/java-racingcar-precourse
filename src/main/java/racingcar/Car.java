package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements ICar {
    private final int MINIMUM_NUMBER = 0;
    private final int MAXIMUM_NUMBER = 9;
    private final int MOVE_NUMBER = 4;
    private final String name;
    private int position = 0;
    private ArrayList<String> trace;

    public Car(String name) {
        this.name = name;
        this.trace = new ArrayList<>();
    }

    @Override
    public boolean pickRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        boolean isMoved = incrementPosition(randomNumber);
        recordPosition();
        return isMoved;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<String> getTrace() {
        return trace;
    }

    private boolean incrementPosition(int number) {
        if (number >= MOVE_NUMBER) {
            position ++;
            return true;
        }
        return false;
    }

    private void recordPosition() {
        String result = name + " : ";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        trace.add(result);
    }
}
