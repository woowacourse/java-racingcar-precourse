package racingcar.domain.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.strategy.RandomMovingStrategy;

class CarDtoTest {

    @Test
    void CarDto_객체_정상_생성된다() {
        Car car = new Car("dto", new RandomMovingStrategy());

        CarDto carDto = CarDto.of(car);

        assertThat(carDto.getName()).isEqualTo("dto");
        assertThat(carDto.getPosition()).isZero();
    }
}
