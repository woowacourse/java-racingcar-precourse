package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void moveCarTest() throws Exception{
        //given
        Car moveCar = new Car("BJ"){
            @Override
            protected int generateRandomNumber() {
                return 4;
            }
        };
        Car notMoveCar = new Car("YJ"){
            @Override
            protected int generateRandomNumber() {
                return 3;
            }
        };
        //when
        moveCar.moveIfRandomNumberIsBiggerThanLimit();
        notMoveCar.moveIfRandomNumberIsBiggerThanLimit();
        //then
        assertFalse(moveCar.isSamePosition(notMoveCar));
    }

    @Test
    public void convertPositiontoBarTest() throws Exception{
        //given
        Car moveCar = new Car("BJ"){
            @Override
            protected int generateRandomNumber() {
                return 4;
            }
        };
        //when
        moveCar.moveIfRandomNumberIsBiggerThanLimit();
        moveCar.moveIfRandomNumberIsBiggerThanLimit();
        //then
        assertEquals("--",moveCar.convertPositionToBar());
    }
}