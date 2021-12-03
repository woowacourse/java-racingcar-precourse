package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName(value = "입력한 입력을 가진 Car 단일 생성")
    void Car_단일_생성() {
        Car car = Car.from("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
