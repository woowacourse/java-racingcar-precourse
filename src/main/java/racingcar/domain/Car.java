package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVE_STANDARD_VALUE = 4;
    private static final String STEP = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void moveStepForward() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    private boolean hasNextStep() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MOVE_STANDARD_VALUE;
    }

    public void drive() {
        if (hasNextStep()) {
            moveStepForward();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append(STEP);
        }
        return String.format("%s : %s", this.name, stringBuilder);
    }

    public boolean isMaxPosition(Car maxPositionCar) {
        return maxPositionCar.position == this.position;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }
}