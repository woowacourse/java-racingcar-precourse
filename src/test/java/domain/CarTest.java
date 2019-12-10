package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getPosition() {
        Car car = Car.generateCar("이름");
        assertEquals(0, car.getPosition());
    }

    @Test
    void move() {
        Car car = Car.generateCar("이름");
        car.move(5);
        assertEquals(1, car.getPosition());
    }

    @Test
    void getCarOriginName() {
        Car car = Car.generateCar("이름");
        assertEquals("이름", car.getCarOriginName());
    }
}