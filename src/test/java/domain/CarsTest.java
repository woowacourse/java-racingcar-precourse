package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;
    private Random random;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("첫번째차");
        names.add("두번쨰차");
        names.add("세번째차");
        cars = new Cars(names);

        random = new Random();
    }

    @Test
    void cars_runOneTime() {
        cars.runOneTime(random);
    }

    @Test
    void cars_showCarsStatus() {
        cars.runOneTime(random);
        cars.runOneTime(random);
        cars.runOneTime(random);

        cars.showCarsStatus();
    }
}