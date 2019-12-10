package domain;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void tryToGoForward() {
        Car car = new Car("a");
        int temp = car.getPosition();

        car.tryToGoForward(3);
        assertEquals(temp, car.getPosition());

        car.tryToGoForward(5);
        assertEquals(temp + 1, car.getPosition());
    }

    @Test
    void getName() {
        Car car = new Car("a");

        String result = car.getName();
        assertEquals("a", result);
    }

    @Test
    void getPosition() {
        Car car = new Car("a");

        int result = car.getPosition();
        assertEquals(0, result);

        car.tryToGoForward(5);
        int resultAfterChange = car.getPosition();
        assertEquals(1, resultAfterChange);
    }
}