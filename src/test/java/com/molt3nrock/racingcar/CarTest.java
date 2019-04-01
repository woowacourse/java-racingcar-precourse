package com.molt3nrock.racingcar;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Collections;
import org.junit.Test;

public class CarTest {

    @Test
    public void toStringNormal() {
        Car car = new Car("foo");
        assertEquals(car.toString(), "foo:");
    }

    @Test(expected = IllegalArgumentException.class)
    public void toStringIllegal() {
        new Car("foobar");
    }

    @Test
    public void move() {
        String name = "foo";
        Car car = new Car(name);
        car.move();
        try {
            Field f = car.getClass().getDeclaredField("position");
            f.setAccessible(true);
            String expected = name + ":" + String.join("", Collections.nCopies((int)f.get(car), "-"));
            assertEquals(expected, car.toString());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}