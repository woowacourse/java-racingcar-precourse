package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
        @Test
        public void printCarPositionTest() throws Exception{
                Car car = new Car("bebe");
                car.move(5);
                car.move(4);
                car.move(1);
                Assertions.assertEquals(car.toString(),"bebe : --");
        }
}