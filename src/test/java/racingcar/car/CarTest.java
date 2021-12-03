package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = Car.from("pobi");
    }

    @Test
    @DisplayName(value = "입력한 입력을 가진 Car 단일 생성")
    void Car_단일_생성() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void Car_이동() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
