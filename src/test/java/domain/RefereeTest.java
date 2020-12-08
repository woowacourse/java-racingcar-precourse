package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class RefereeTest extends Random{
    @Override
    public int nextInt() {
        return 1;
    }

    @Test
    void 최대_거리_계산_테스트() {
        Car car1 = new Car("one");
        Car car2 = new Car("two");
        car1.moveCar(5);
        car1.moveCar(5);
        car1.moveCar(5);
        car1.moveCar(5);
        car1.moveCar(5);
        car2.moveCar(5);
        car2.moveCar(5);
        car2.moveCar(5);

        Referee referee = new Referee();
        int result = referee.calculateMaxPosition(Arrays.asList(car1,car2));

        Assertions.assertEquals(5, result);
    }

    @Test
    void 우승자_리스트_선정_테스트() {
        Car car1 = new Car("one");
        Car car2 = new Car("two");
        Car car3 = new Car("three");
        car1.moveCar(5);
        car1.moveCar(5);
        car1.moveCar(5);
        car2.moveCar(5);
        car2.moveCar(5);
        car2.moveCar(5);
        car3.moveCar(5);

        List<Car> carList = Arrays.asList(car1,car2,car3);
        Referee referee = new Referee();
        referee.calculateMaxPosition(carList);

        Assertions.assertEquals(Arrays.asList(car1,car2), referee.setWinner(carList).getRaceWinners());
    }
}