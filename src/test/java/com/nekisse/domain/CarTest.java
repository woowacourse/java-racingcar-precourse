package com.nekisse.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 자동차_생성시_이름이_5글자_이하() {
        Car car = new Car(CarName.newCarName("aaaaa"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자동차_생성시_이름이_5글자_초과_익셉션() {
        Car car1 = new Car(CarName.newCarName("a2345육"));
    }

    @Test
    public void 받은숫자가_3보다_클때_이동가능() {
        Car car = new Car(CarName.newCarName("자동차"));
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 받은숫자가_3이하_일때_이동_불가능() {
        Car car = new Car(CarName.newCarName("자동차"));
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}