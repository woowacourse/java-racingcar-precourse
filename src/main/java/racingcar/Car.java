package racingcar;

import racingcar.game.io.print.OutputPrint;
import utils.RandomUtils;

public class Car {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void goForwardRandomly() {
        int numberToGoForward = RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        position += numberToGoForward;
    }

    public void printCurrentState() {
        OutputPrint.printCarName(name);
        OutputPrint.printCarState(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
