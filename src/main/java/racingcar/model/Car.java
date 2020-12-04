package racingcar.model;

import racingcar.view.OutputGuide;
import utils.RandomUtils;

public class Car {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int RUNNING_CRITERIA = 4;

    private final OutputGuide outputGuide;
    private final String name;

    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        outputGuide = new OutputGuide();
    }

    public void run() {
        if (canRun()) {
            position++;
        }
        outputGuide.drawTrace(getName(), position);
    }

    private boolean canRun() {
        return RandomUtils.nextInt(MIN, MAX) >= RUNNING_CRITERIA;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
