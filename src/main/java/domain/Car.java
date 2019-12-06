package domain;

import java.util.LinkedList;
import java.util.List;

public class Car {
    private static final int MOVEMENT_VALUE = 1;
    private final String name;
    private int position = 0;
    private List<Integer> goForward = new LinkedList<>();

    public Car(String name) {
        this.name = name;
    }

    public void goForwardPosition() {
        position += MOVEMENT_VALUE;
    }

    public void setGoForward(List<Integer> goForward) {
        this.goForward = goForward;
    }

    public int getGoForward(int index) {
        return goForward.get(index);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
