package domain;

import java.util.Arrays;
import java.util.Comparator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void movePositionByOne() {
        this.position++;
    }
}
