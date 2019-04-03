package com.nekisse.domain;

import org.junit.Test;

public class CarTest {

    @Test
    public void 자동차_생성시_이름이_5글자_이하() {
        Car car = new Car(CarName.newCarName("aaaaa"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자동차_생성시_이름이_5글자_초과_익셉션() {
        Car car1 = new Car(CarName.newCarName("a2345육"));
    }
}