package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car에 대한 테스트")
class CarTest {

    @DisplayName("원하는 이름으로 Car를 생성한다.")
    @Test
    void createCarByName() {
        final String expect = "test";

        final Car car = Car.of(expect, NormalCarMoveStrategy.getInstance());

        assertEquals(car.getName(), expect);
    }

    @DisplayName("Car는 움직임 전략 조건을 만족하면 1만큼 앞으로 전진한다.")
    @Test
    void move() {
        final Car car = Car.of("test", value -> true);
        final int meaninglessValue = 0;

        car.move(meaninglessValue);

        assertEquals(car.getPosition(), Car.DEFAULT_POSITION + 1);
    }

    @DisplayName("Car는 움직임 전략 조건을 만족하지 못하면 움직이기를 시도해도 전진하지 않는다.")
    @Test
    void moveFail() {
        final Car car = Car.of("test", value -> false);
        final int meaninglessValue = 0;

        car.move(meaninglessValue);

        assertEquals(car.getPosition(), Car.DEFAULT_POSITION);
    }
}