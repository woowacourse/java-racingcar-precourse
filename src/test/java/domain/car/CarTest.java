package domain.car;

import domain.car.engine.Engine;
import domain.car.engine.FixEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("엔진 출력값에 따라 움직임 여부 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "5,1"})
    void move(int power, int expectPosition) {
        Car car = new Car("pci");
        Engine engine = new FixEngine(power);

        car.move(engine);

        assertThat(car.getPosition()).isEqualTo(expectPosition);
    }

    @DisplayName("이름 객체로부터 이름값 가져오기")
    @Test
    void getName() {
        String rawName = "pci";
        Car car = new Car(rawName);
        assertThat(car.getName()).isEqualTo(rawName);
    }
}