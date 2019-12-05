package domain;

import java.util.LinkedList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private List<Integer> goForward = new LinkedList<>();

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
}
