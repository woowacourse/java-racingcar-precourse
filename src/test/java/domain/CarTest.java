package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @Test
    @DisplayName("#go")
    void go() {
        //given
        car = new Car("testCar");
        int defaultPosition = car.getPosition();

        //when
        car.go();

        //then
        assertEquals(defaultPosition + RacingGameConfig.STEP, car.getPosition());
    }

    @Test
    @DisplayName("#getPosition")
    void getPosition() {
        //given
        int position = 3;
        car = new Car("testCar", position);

        //when & then
        assertEquals(position, car.getPosition());
    }

    @Test
    @DisplayName("#getId: id increase automatically when construct car")
    void getId() {
        //given
        Car car = new Car("testCar");
        int currentId = car.getId();

        for (int i = currentId + 1; i <= currentId + 10; i++) {
            car = new Car("testCar");
            assertEquals(i, car.getId());
        }
    }

    @Test
    @DisplayName("#equals")
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
    @DisplayName("#compareTo: return 1")
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
        Car carWithLowerId = new Car(id - 1, name, position);
        //when & then
        assertEquals(1, car.compareTo(carWithLowerId));
    }

    @Test
    @DisplayName("#compareTo: return 0")
    void compareToReturn0() {
        //given
        int id = 1;
        String name = "testCar";
        int position = 2;
        car = new Car(id, name, position);
        Car carWhichIsSame = new Car(id, name, position);
        //when & then
        assertEquals(0, car.compareTo(carWhichIsSame));
    }

    @Test
    @DisplayName("#compareTo: return -1")
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
    @DisplayName("#toString")
    void toStringOfCar() {
        //given
        Car car = new Car(0, "testCar", 3);

        //when & then
        assertEquals("testCar", car.toString());
    }
}