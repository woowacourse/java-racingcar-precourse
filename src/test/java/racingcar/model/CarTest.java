package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_포지션_대쉬로_변환_기능() {
        Car car = new Car("test");
        car.forward();
        car.forward();
        car.forward();
        String convertedPosition = car.positionConvertToDash();

        assertThat(convertedPosition).isEqualTo("---");
    }

    @Test
    void 출력용_자동차_정보_반환_기능() {
        Car car = new Car("test");
        car.forward();
        car.forward();
        Map<String, String> carInfos = car.getCarInfos();
        String carName = carInfos.get("name");
        String position = carInfos.get("position");

        assertThat(carName).isEqualTo("test");
        assertThat(position).isEqualTo("--");
    }
}