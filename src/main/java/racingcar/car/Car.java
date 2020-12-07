package racingcar.car;

import utils.RandomUtils;

public class Car {

    public static final int MINIMUM_DECISION_VALUE = 0;
    public static final int MAXIMUM_DECISION_VALUE = 9;
    public static final int NOT_FORWARD_DECISION_BOUNDARY = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int decision = getRandomDecision();
        if (isForwardDecision(decision)) {
            forward();
        }
    }

    private int getRandomDecision() {
        return RandomUtils.nextInt(MINIMUM_DECISION_VALUE, MAXIMUM_DECISION_VALUE);
    }

    private boolean isForwardDecision(int decision) {
        return decision > NOT_FORWARD_DECISION_BOUNDARY;
    }

    private void forward() {
        ++position;
    }

    public boolean isPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + getPositionGraphic();
    }

    private String getPositionGraphic() {
        StringBuilder positionGraphic = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            positionGraphic.append('-');
        }
        return positionGraphic.toString();
    }
}
