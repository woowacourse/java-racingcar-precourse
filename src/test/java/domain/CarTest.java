package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car1, car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("car 1");
        car2 = new Car("car 2");
    }

    @Test
    void getPosition() {
        assertEquals(0, car1.getPosition());
        assertEquals(0, car2.getPosition());
    }

    @Test
    void move() {
        car2.move();
        car2.move();
        assertEquals(0, car1.getPosition());
        assertEquals(2, car2.getPosition());
    }

    @Test
    void getName() {
        assertEquals("car 1", car1.getName());
        assertEquals("car 2", car2.getName());
    }


}