package racingcar.model;

import java.util.stream.IntStream;
import utils.RandomUtils;

public class Car {

    private static final String COLON = " : ";
    private static final String POSITION_DASH = "-";
    public static final int MIN = 0;
    public static final int MAX = 9;
    public static final int RUNNING_CRITERIA = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void run() {
        if (canRun()) {
            position++;
        }
        System.out.println(getName() + COLON + drawTrace());
    }

    private boolean canRun() {
        return RandomUtils.nextInt(MIN, MAX) >= RUNNING_CRITERIA;
    }

    public String drawTrace() {
        StringBuilder carPosition = new StringBuilder();
        IntStream.range(MIN,position)
            .forEach(value -> carPosition.append(POSITION_DASH));
        return carPosition.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
