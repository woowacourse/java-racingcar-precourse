package com.molt3nrock.racingcar;

import static org.junit.Assert.*;

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
}