package racingcar.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarDtoTest {

    @DisplayName("CarDto 객체는 Car 객체를 인자로 받아 생성")
    @Test
    void CarDto_객체_정상_생성된다() {
        Car car = new Car("dto", new RandomMovingStrategy());
        CarDto carDto = CarDto.from(car);

        String name = carDto.getName();
        int position = carDto.getPosition();

        assertThat(name).isEqualTo("dto");
        assertThat(position).isZero();
    }
}
