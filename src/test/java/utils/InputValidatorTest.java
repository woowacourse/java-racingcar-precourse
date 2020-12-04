package utils;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Rounds;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test()
    void checkValidCarName() {
        assertThrows(IllegalArgumentException.class, ()->{
            Car c = new Car("");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            Car c = new Car(" ");
        });

        assertThrows(IllegalArgumentException.class, ()->{
            Car c = new Car("asdfsadf");
        });
    }

    @Test
    void checkDuplicatedCarName() {
        assertThrows(IllegalArgumentException.class, ()->{
            String[] names = new String[]{"a","b","a"};
            CarsFactory.createCars(names);
        });
    }

    @Test
    void checkValidRounds() {
        assertThrows(IllegalArgumentException.class, ()->{
            Rounds rounds = Rounds.initialize(-1);
        });
    }
}