package controller;

import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarControllerTest {

    @Test
    void getCar() {

        CarController list = new CarController();

        Car car1 = new Car("name");
        Car car2 = new Car("이름");

        list.addCar(car1);
        list.addCar(car2);

        // 실패
        assertNull(list.getCar("none"));

        // 성공
        assertSame(list.getCar("name"), car1);
        assertSame(list.getCar("이름"), car2);
    }

    @Test
    void moveCar() {

        CarController list = new CarController();

        Car car1 = new Car("na이름");

        list.addCar(car1);

        list.moveCar("na이름");

        assertEquals(1, list.getCar("na이름").getPosition());


    }

    @Test
    void getCarPosition() {

        CarController list = new CarController();

        Car car = new Car("name");

        list.addCar(car);

        list.moveCar("name");
        list.moveCar("name");

        // 실패
        assertEquals(-1, list.getCarPosition("none").orElse(-1));

        // 성공
        assertEquals(2, list.getCarPosition("name").orElse(-1));
    }
}