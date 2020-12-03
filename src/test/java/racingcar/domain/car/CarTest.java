package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
                () -> assertThat(car).extracting("name").isEqualTo(carName),
                () -> assertThat(car).extracting("position").isEqualTo(0)
        );
    }

    @DisplayName("자동차 이름이 자동차 이름 제한 길이보다 큰 경우 예외를 발생시킨다 ")
    @Test
    void testInitCarIfCarNameOverThanCarNameLimitLength() {
        //given
        String carName = "longCarName";

        //when //then
        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
