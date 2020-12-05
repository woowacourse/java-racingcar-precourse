package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"tico,1", "equus,2"})
    @DisplayName("자동차의 연료가 부족할 시 멈춤 테스트")
    public void move_lowerThanCondition_DoNotMove(String carName, int fuel) {

        // given
        Car car = new Car(carName, fuel);
        Car expectedCar = new Car(carName, 0, fuel);

        // when
        car = car.move();

        // then
        assertThat(car).isEqualTo(expectedCar);
    }

    @ParameterizedTest
    @CsvSource({"lexus,4", "SM5,5"})
    @DisplayName("자동차의 연료가 충분할 시 전진 테스트")
    public void move_UpperThanCondition_Move(String carName, int fuel) {

        // given
        Car car = new Car(carName, fuel);
        Car expectedCar = new Car(carName, 1, fuel);

        // when
        car = car.move();

        // then
        assertThat(car).isEqualTo(expectedCar);
    }
}
