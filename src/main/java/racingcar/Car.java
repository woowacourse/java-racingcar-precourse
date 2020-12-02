package racingcar;

import utils.RandomUtils;

public class Car {

    public static final int MINIMUM_DECISION_VALUE = 0;
    public static final int MAXIMUM_DECISION_VALUE = 9;
    public static final int DECISION_BOUNDARY = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int decision = RandomUtils.nextInt(MINIMUM_DECISION_VALUE, MAXIMUM_DECISION_VALUE);
        if (decision > DECISION_BOUNDARY) {
            forward();
        }
    }

    public void forward() {
        ++position;
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
