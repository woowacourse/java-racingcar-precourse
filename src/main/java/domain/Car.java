/*
 *  @Car.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.06
 *
 *  @Author: pandahun
 */

package domain;

import domain.Name;
import domain.RandomValue;

public class Car {

    private static final int BOUNDARY = 4;

    private final Name name;
    private int position = 0;

    public Car( String name ) {
        this.name = new Name(name);
    }

    public void forward() {
        int randomValue = new RandomValue().getRandomValue();
        if(isRunnable(randomValue))
            this.position++;
    }

    private boolean isRunnable(int randomValue) {
        return randomValue >= BOUNDARY;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() { return position};
}
