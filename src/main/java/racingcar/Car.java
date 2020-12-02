package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private int position = 0;
    public int goCount = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void changePosition() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }
    public int getPosition() {
        return this.position;
    }
}
