package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @DisplayName("Car 객체를 생성하는 기능을 테스트한다 ")
    @Test
    void testInitCar() {
        //given
        String carName = "carA";

        //when
        Car car = new Car(carName);

        //then
        assertAll(
                () -> assertThat(car).extracting("name").extracting("name").isEqualTo(carName),
                () -> assertThat(car).extracting("position").isEqualTo(0)
        );
    }

    @DisplayName("자동차가 전진 or 정지하는 기능을 테스트한다 ")
    @ParameterizedTest
    @CsvSource(value = {
            "car,true,1",
            "car,false,0"
    })
    void testMoveForwardOrStop(String carName, boolean isMovable, int expectedPosition) {
        //given
        Car car = new Car(carName);

        //when
        car = car.moveForwardOrStop(isMovable);

        //then
        assertThat(car).extracting("position").isEqualTo(expectedPosition);
    }
}
