package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    private static final int CONDITIONS_TO_MOVE_FORWARD = 4;
    private static final char CAR_TRACE = '-';

    public Car(String name) {
        this.name = name;
    }

    private int generateRandomNum() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    protected void moveCar() {
        if (generateRandomNum() >= CONDITIONS_TO_MOVE_FORWARD) {
            position++;
        }
    }

    protected void printCarPosition() {
        String trace = makeTrace();
        System.out.println(name + " : " + trace);
    }

    private String makeTrace() {
        if (position == 0) {
            return " ";
        }
        String trace = String.format("%" + Integer.toString(position) + "s", " ").replace(' ', CAR_TRACE);
        return trace;
    }

    protected int getPosition() {
        return position;
    }

    protected String getCarName() {
        return name;
    }

}
