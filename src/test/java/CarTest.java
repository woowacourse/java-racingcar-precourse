import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    Car car;

    @BeforeEach
    public void Car_객체생성() {
        car = new Car("parkcar");
    }

    @Test
    public void move_실행된다() {
        car.move();
        assertEquals(car.getPosition(), 1);
    }

}
