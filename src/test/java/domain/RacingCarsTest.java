package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new LinkedList<>();
        carList.add(new Car("car 1"));
        carList.add(new Car("car 2"));
        racingCars = new RacingCars(carList);
    }

    @Test
    void getCarList() {
        List<Car> carList = racingCars.getCarList();
        assertEquals("car 1", carList.get(0).getName());
        assertEquals("car 2", carList.get(1).getName());
    }
}