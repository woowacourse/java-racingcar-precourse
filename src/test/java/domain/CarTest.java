package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest()
    @ValueSource(strings = {"A","AB","ABC","ABCD","ABCDE"})
    void 이름_1자이상_5자이하_자동차_생성(String carName) {
        Car car = new Car(carName);
        assertThat(car).extracting("name").isEqualTo(carName);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"", "ABCDEF"})
    void 이름_길이_범위_벗어나는_자동차_생성(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
