package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
                () -> assertThat(car).extracting("name").isEqualTo(carName),
                () -> assertThat(car).extracting("position").isEqualTo(0)
        );
    }
}
