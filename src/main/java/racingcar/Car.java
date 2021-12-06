package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private final String MARK = "-";
    private final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isPossibleMoveForward(int randomValue) {
        return randomValue >= MOVE_CONDITION;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    public void updatePosition() {
        position++;
    }

    private String indicatePosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < position; count++) {
            stringBuilder.append(MARK);
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return name + " : " + indicatePosition();
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }
}
