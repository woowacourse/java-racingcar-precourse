package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void initCar() {
        car = new Car("porsche");
    }

    @Test
    void move() {
        car.move();
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void stop() {
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void getName() {
        assertEquals(car.getName(), "porsche");
    }

    @Test
    void getPosition() {
        assertEquals(car.getPosition(), 0);
    }
}