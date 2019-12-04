import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class RacingCarTest {
    private int repeatTime;
    private final List<Car> cars = new LinkedList<>();

    @BeforeEach
    void setUp() {
        repeatTime = 5;
        cars.add(new Car("pobbi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));
    }

    @Test
    void testRacingCar() {
        for(Car car : cars){
            // TODO: 2019-12-04 전진 or 멈춤 임의로 지정
        }
        // TODO: 2019-12-04  assert 메소드로 확인
    }
}