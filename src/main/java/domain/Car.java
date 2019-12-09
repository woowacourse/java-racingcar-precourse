/*
 *  @Car.java
 *
 *  @Version: 0.3
 *
 *  @Date: 2019.12.09
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

    public void forward(RandomValue randomValue) {
        int value = randomValue.getRandomValue();
        if(isRunnable(value))
            this.position++;
    }

    private boolean isRunnable(int randomValue) {
        return randomValue >= BOUNDARY;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() { return position;}
}
