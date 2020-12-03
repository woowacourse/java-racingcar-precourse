package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Car {
    private static final int GO_THRESHOLD = 4;
    private static final String POSITION_BAR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void changePosition(int randomNumber) {
        if (GO_THRESHOLD <= randomNumber) {
            this.position++; // GO
        }
    }

    public String getVisualCarPosition() {
        // generate progress bar of car position (e.g. "---")
        return new String(new char[this.position]).replace("\0", POSITION_BAR);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
