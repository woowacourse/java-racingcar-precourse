import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car;

    @BeforeEach
    public void Car_객체생성() {
        car = new Car("parkcar");
    }

    @Test
    public void tryMove_실행된다() {
        car.tryMove();
        assertEquals(car.getPosition(), 1);
    }

    @Test
    public void toString_잘반환된다() {
        assertEquals(car.toString(), "parkcar : ");
    }

}
