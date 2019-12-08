package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("testCar");
    }

    @Test
    void go() {
        //given

        int defaultPosition = car.getPosition();

        //when
        car.go();

        //then
        assertEquals(defaultPosition + RacingGameConfig.STEP, car.getPosition());
    }

    @Test
    void getPosition() {
        //given
        int position = 3;
        car = new Car(0, "testCar", position);

        //when & then
        assertEquals(position, car.getPosition());
    }

    @Test
    void equals() {
        //given
        car = new Car("rightName");
        Car sameCar = new Car("rightName");
        // when & then
        assertEquals(sameCar, car);

        //given
        Car differentCar = new Car("wrongName");
        //when & then
        assertNotEquals(differentCar, car);
    }

    @Test
    void compareToReturn1() {
        //given
        int id = 2;
        String name = "testCar";
        int position = 2;
        car = new Car(id, name, position);
        Car carWithLowPosition = new Car(id, name, position - 1);
        //when & then
        assertEquals(1, car.compareTo(carWithLowPosition));

        //given
        Car carWithLowerId = new Car(id -1, name, position);
        //when & then
        assertEquals(1, car.compareTo(carWithLowerId));
    }
    @Test
    void compareToReturn0() {
        //given
        int id = 1;
        String name = "testCar";
        int position = 2;
        car = new Car(id, name, position);
        Car carWhichIsSame =  new Car(id, name, position);
        //when & then
        assertEquals(0, car.compareTo(carWhichIsSame));
    }
    @Test
    void compareToReturnMinus1() {
        //given
        int id = 1;
        String name = "testCar";
        int position = 2;
        car = new Car(id, name, position);
        Car carWithHigherPosition = new Car(id, name, position + 1);
        //when & then
        assertEquals(-1, car.compareTo(carWithHigherPosition));

        //given
        Car carWithHigherId = new Car(id + 1, name, position);
        //when & then
        assertEquals(-1, car.compareTo(carWithHigherId));
    }

    @Test
    void toStringOfCar() {
        //given
        Car car = new Car(0, "testCar", 3);

        //when & then
        assertEquals("testCar", car.toString());
    }
}